package com.github.orelzion.gifai.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.orelzion.gifai.model.openai.OpenAiRepository
import com.github.orelzion.gifai.model.tensor.TensorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class GifAiState {
    object Loading : GifAiState()
    data class Success(val gifUrl: String, val gifTerm: String) : GifAiState()
    data class Error(val error: String) : GifAiState()
}

class GifAiViewModel(
    private val tensorRepository: TensorRepository,
    private val openAiRepository: OpenAiRepository
) : ViewModel() {

    private val stateFlow = MutableStateFlow<GifAiState>(GifAiState.Success("", ""))
    val state = stateFlow.asStateFlow()

    fun searchGifs(query: String) {
        viewModelScope.launch {
            stateFlow.update { GifAiState.Loading }

            openAiRepository.getCompletions(query).onSuccess { predictedGif ->
                tensorRepository.search(predictedGif).onSuccess { response ->
                    stateFlow.update {
                        val firstResult = response.results.first()
                        GifAiState.Success(
                            gifUrl = firstResult.media.first().gif.url,
                            gifTerm = "$predictedGif: ${firstResult.content_description}"
                        )
                    }
                }.onFailure { error ->
                    stateFlow.update {
                        GifAiState.Error(error.message ?: "Unknown error")
                    }
                }
            }.onFailure { error ->
                stateFlow.update {
                    GifAiState.Error(error.message ?: "Unknown error")
                }
            }
        }
    }

}