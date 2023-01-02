package com.github.orelzion.gifai.model.tenor

import retrofit2.http.GET
import retrofit2.http.Query

interface TenorApi {
    @GET("v1/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("limit") limit: Int = 1
    ): TenorResponse
}
