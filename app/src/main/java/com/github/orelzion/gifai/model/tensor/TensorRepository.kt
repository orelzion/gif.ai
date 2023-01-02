package com.github.orelzion.gifai.model.tensor

import com.github.orelzion.gifai.BuildConfig

interface TensorRepository {
    suspend fun search(query: String): Result<TensorResponse>
}

class TensorRepositoryImpl(
    private val api: TensorApi
) : TensorRepository {
    override suspend fun search(query: String) = runCatching {
        api.search(query, BuildConfig.TENSOR_API_KEY, limit = 1)
    }
}
