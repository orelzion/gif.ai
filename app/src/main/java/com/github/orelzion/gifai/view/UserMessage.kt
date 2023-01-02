package com.github.orelzion.gifai.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserMessage(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Card(
            modifier = modifier
                .align(Alignment.CenterStart),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary
            ),
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = text
            )
        }
    }
}

@Preview
@Composable
fun UserMessagePreview() {
    UserMessage(text = "Hello")
}
