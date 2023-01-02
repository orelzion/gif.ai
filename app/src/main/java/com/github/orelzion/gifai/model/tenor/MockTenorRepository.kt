package com.github.orelzion.gifai.model.tenor

class MockTenorRepository: TenorRepository {
    override suspend fun search(query: String): Result<TenorResponse> {
        return Result.success(
            TenorResponse(
                results = listOf(
                    TenorResult(
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