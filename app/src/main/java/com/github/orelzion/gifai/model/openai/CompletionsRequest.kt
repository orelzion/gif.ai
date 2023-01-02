package com.github.orelzion.gifai.model.openai

import kotlinx.serialization.Serializable

@Serializable
data class CompletionRequest(
    val model: String,
    val prompt: String,
    val temperature: Double,
    val max_tokens: Int,
    val top_p: Int,
    val frequency_penalty: Int,
    val presence_penalty: Int
)

@Serializable
data class CompletionResponse(
    val id: String,
    val created: Int,
    val model: String,
    val choices: List<Choice>
)

@Serializable
data class Choice(
    val text: String,
    val index: Int,
)
