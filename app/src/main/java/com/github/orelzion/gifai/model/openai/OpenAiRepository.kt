package com.github.orelzion.gifai.model.openai

import com.github.orelzion.gifai.BuildConfig

interface OpenAiRepository {
    suspend fun getCompletions(forMessage: String): Result<String>
}

class OpenAiRepositoryImpl(
    private val openAiApi: OpenAiApi
) : OpenAiRepository {
    override suspend fun getCompletions(forMessage: String) = kotlin.runCatching {
        openAiApi.getCompletions(
            "application/json",
            "Bearer ${BuildConfig.OPEN_AI_API_KEY}",
            CompletionRequest(
                model = "text-davinci-003",
                prompt = "sarcastic gif reply\\nDo you have any plans for the weekend?\\n\\n[shrugging]\\n\\nI'm so excited for the concert next week!\\n\\n[bored]\\n\\nI can't believe the school year is almost over!\\n\\n[confetti]\\n\\nI'm going to the mall with some friends later, do you want to come?\\n\\n[smiling] \\n\\nI'm sorry I couldn't make it to your game yesterday, how did it go?\\n\\n[thumbs up] \\n\\n$forMessage\\n\\n",
                temperature = 0.7,
                max_tokens = 256,
                top_p = 1,
                frequency_penalty = 0,
                presence_penalty = 0
            )
        ).choices.first().text.split("[").last()
    }
}
