package com.github.orelzion.gifai.model.tenor

import kotlinx.serialization.Serializable

@Serializable
data class TenorResponse(
    val results: List<TenorResult>
)

@Serializable
data class TenorResult(
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
