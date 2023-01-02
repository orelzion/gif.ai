package com.github.orelzion.gifai.model.tensor

import kotlinx.serialization.Serializable

@Serializable
data class TensorResponse(
    val results: List<TensorResult>
)

@Serializable
data class TensorResult(
    val id: String,
    val title: String,
    val content_description: String,
    val content_rating: String,
    val h1_title: String,
    val media: List<Media>
)

@Serializable
data class Media(
    val gif: Gif
)

@Serializable
data class Gif(
    val dims: List<Int>,
    val size: Int,
    val preview: String,
    val url: String
)
