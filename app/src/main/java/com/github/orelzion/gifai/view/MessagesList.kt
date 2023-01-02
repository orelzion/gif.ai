package com.github.orelzion.gifai.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.orelzion.gifai.viewmodel.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MessagesList(
    messages: List<Message>
) {
    var currentSize by rememberSaveable { mutableStateOf(messages.size) }
    val isItemAdded by  remember {
        mutableStateOf(messages.size > currentSize)
    }

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    LaunchedEffect(isItemAdded) {
        coroutineScope.launch(Dispatchers.Main) {
            scrollState.animateScrollTo(scrollState.maxValue)
            currentSize = messages.size
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(messages) { message ->
                when (message) {
                    is Message.Bot -> {
                        GifImage(imageUrl = message.gifUrl)
                    }
                    is Message.User -> {
                        UserMessage(text = message.text)
                    }
                }
            }
        }
    }
}
