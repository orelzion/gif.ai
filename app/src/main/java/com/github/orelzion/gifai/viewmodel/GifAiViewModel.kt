package com.github.orelzion.gifai.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.orelzion.gifai.model.openai.OpenAiRepository
import com.github.orelzion.gifai.model.tenor.TenorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class GifAiState {
    abstract val messages: List<Message>

    data class Loading(override val messages: List<Message>) : GifAiState()
    data class Success(override val messages: List<Message>) : GifAiState()
    data class Error(val error: String, override val messages: List<Message>) : GifAiState()
}

sealed class Message {
    data class User(val text: String) : Message()
    data class Bot(val gifUrl: String) : Message()
}

class GifAiViewModel(
    private val tenorRepository: TenorRepository,
    private val openAiRepository: OpenAiRepository
) : ViewModel() {

    private val stateFlow = MutableStateFlow<GifAiState>(GifAiState.Success(emptyList()))
    val state = stateFlow.asStateFlow()

    fun searchGifs(query: String) {

        stateFlow.update {
            GifAiState.Success(
                messages = it.messages + Message.User(query)
            )
        }

        viewModelScope.launch {
            stateFlow.update { GifAiState.Loading(it.messages) }

            openAiRepository.getCompletions(query).onSuccess { predictedGif ->
                tenorRepository.search(predictedGif).onSuccess { response ->
                    stateFlow.update {
                        val firstResult = response.results.first()
                        GifAiState.Success(
                            messages = it.messages + Message.Bot(firstResult.media.first().gif.url)
                        )
                    }
                }.onFailure { error ->
                    stateFlow.update {
                        GifAiState.Error(error.message ?: "Unknown error", it.messages)
                    }
                }
            }.onFailure { error ->
                stateFlow.update {
                    GifAiState.Error(error.message ?: "Unknown error", it.messages)
                }
            }
        }
    }

}