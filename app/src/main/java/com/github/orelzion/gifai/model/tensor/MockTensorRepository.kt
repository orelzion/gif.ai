package com.github.orelzion.gifai.model.tensor

class MockTensorRepository: TensorRepository {
    override suspend fun search(query: String): Result<TensorResponse> {
        return Result.success(
            TensorResponse(
                results = listOf(
                    TensorResult(
                        media = listOf(
                            Media(
                                gif = Gif(
                                    url = "https://media.tenor.com/images/3b2b1b2b1b2b1b2b1b2b1b2b1b2b1b2b/tenor.gif",
                                    dims = listOf(480, 270),
                                    size = 0,
                                    preview = "https://media.tenor.com/images/3b2b1b2b1b2b1b2b1b2b1b2b1b2b1b2b/tenor.gif"
                                )
                            )
                        ),
                        id = "",
                        title = "",
                        content_description = "",
                        content_rating = "",
                        h1_title = "",
                    )
                )
            )
        )
    }
}