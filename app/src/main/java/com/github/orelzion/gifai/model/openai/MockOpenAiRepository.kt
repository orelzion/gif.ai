package com.github.orelzion.gifai.model.openai

class MockOpenAiRepository: OpenAiRepository {
    override suspend fun getCompletions(forMessage: String): Result<String> {
        return Result.success("I'm a mock response")
    }
}