package com.github.orelzion.gifai.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.github.orelzion.gifai.R

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    Box(modifier = modifier.fillMaxWidth()) {
        Card(
            modifier = modifier.align(Alignment.CenterEnd),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.secondary),
        ) {
            AsyncImage(
                modifier = Modifier.widthIn(min = 250.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .build(),
                imageLoader = imageLoader,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.placeholder),
                contentDescription = null,
                onError = { it.result.throwable.printStackTrace() }
            )
        }
    }
}

@Preview
@Composable
fun GifImagePreview() {
    GifImage(
        imageUrl = "https://media.tenor.com/images/3b2b1b2b1b2b1b2b1b2b1b2b1b2b1b2b/tenor.gif"
    )
}
