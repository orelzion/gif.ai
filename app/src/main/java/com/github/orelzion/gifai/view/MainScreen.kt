package com.github.orelzion.gifai.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.orelzion.gifai.model.openai.MockOpenAiRepository
import com.github.orelzion.gifai.model.tenor.MockTenorRepository
import com.github.orelzion.gifai.viewmodel.GifAiState
import com.github.orelzion.gifai.viewmodel.GifAiViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: GifAiViewModel = koinViewModel()) {

    val viewState = viewModel.state.collectAsState()

    val message = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            MessagesList(messages = viewState.value.messages)
        }
        InputArea(message) {
            viewModel.searchGifs(message.value)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        GifAiViewModel(
            MockTenorRepository(),
            MockOpenAiRepository()
        )
    )
}

@Composable
private fun InputArea(
    message: MutableState<String>,
    onSendClicked: () -> Unit
) {
    InputAndSubmit(
        modifier = Modifier
            .fillMaxWidth(),
        text = message.value, onMessageChanged = { message.value = it },
        onSendClicked = {
            onSendClicked()
            message.value = ""
        }
    )
}

@Composable
private fun ErrorState(viewState: State<GifAiState>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = (viewState.value as GifAiState.Error).error,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
    }
}

@Composable
private fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Loading...",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
    }
}
