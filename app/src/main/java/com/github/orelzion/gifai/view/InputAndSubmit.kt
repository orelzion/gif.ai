package com.github.orelzion.gifai.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
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
            .height(56.dp)
            .imePadding()
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .background(Color.White)
                .padding(16.dp),
            value = text,
            onValueChange = onMessageChanged,
        )
        // A send button
        Button(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            shape = RectangleShape,
            onClick = onSendClicked
        ) {
            Text(text = "Send")
        }
    }
}

@Preview
@Composable
fun InputAndSubmitPreview() {
    InputAndSubmit(
        text = "Hello",
        onMessageChanged = {},
        onSendClicked = {}
    )
}
