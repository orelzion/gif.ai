package com.github.orelzion.gifai.model.tenor

import com.github.orelzion.gifai.BuildConfig

interface TenorRepository {
    suspend fun search(query: String): Result<TenorResponse>
}

class TenorRepositoryImpl(
    private val api: TenorApi
) : TenorRepository {
    override suspend fun search(query: String) = runCatching {
        api.search(query, BuildConfig.TENOR_API_KEY, limit = 1)
    }
}
