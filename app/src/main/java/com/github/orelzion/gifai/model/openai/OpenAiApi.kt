package com.github.orelzion.gifai.model.openai

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAiApi {
    @POST("completions")
    suspend fun getCompletions(
        @Header("Content-Type") contentType: String,
        @Header("Authorization") authorization: String,
        @Body request: CompletionRequest
    ): CompletionResponse
}
