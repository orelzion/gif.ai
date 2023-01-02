package com.github.orelzion.gifai.model.tensor

import retrofit2.http.GET
import retrofit2.http.Query

interface TensorApi {
    @GET("v1/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("limit") limit: Int = 1
    ): TensorResponse
}
