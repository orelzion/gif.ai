package com.github.orelzion.gifai.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputAndSubmit(
    modifier: Modifier = Modifier,
    text: String,
    onMessageChanged: (String) -> Unit = {},
    onSendClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .imePadding()
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(3f)
                .background(Color.White)
                .padding(8.dp),
            value = text,
            onValueChange = onMessageChanged,
        )
        // A send button
        Button(
            modifier = Modifier.weight(1f),
            onClick = onSendClicked
        ) {
            Text(text = "Send")
        }
    }
}
