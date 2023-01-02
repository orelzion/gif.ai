package com.github.orelzion.gifai.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
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

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        modifier = modifier,
        imageLoader = imageLoader,
        contentScale = ContentScale.Fit,
        placeholder = painterResource(id = R.drawable.placeholder),
        error = painterResource(id = R.drawable.placeholder),
        contentDescription = null,
        onError = { it.result.throwable.printStackTrace() }
    )
}
