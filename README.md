# Project Title

🔍 Find the perfect GIF for every situation with this app! 

🤣 I use the [Tenor API](https://tenor.com/gifapi/documentation#quickstart) to search for GIFs

🤖 OpenAI API to generate sarcastic search terms. 

It's the ultimate tool for finding the perfect response GIF.

## Installation

1. Obtain API keys for Tenor and OpenAI:

- Tenor API: Sign up for a free API key at https://tenor.com/developer/keyregistration.
- OpenAI API: Sign up for a free API key at https://beta.openai.com/signup/developer.

2. Create a `secrets.properties` file in the root directory of your project, and add the following lines, replacing `YOUR_TENOR_API_KEY` and `YOUR_OPENAI_API_KEY` with your actual API keys:
```
TENOR_API_KEY=YOUR_TENOR_API_KEY
OPEN_AI_API_KEY=YOUR_OPENAI_API_KEY
```

3. Sync the project:
`./gradlew sync`

4. Run the project
`./gradlew run`


## Usage

Instructions on how to use your project and examples of common use cases.

## 🎉 Features 🎉

- Search for GIFs using the Tenor API
- Generate sarcastic search terms using the OpenAI API
- View GIF and search term

## 📷 Previews

<p align="center">
<img src="https://user-images.githubusercontent.com/1846941/210208798-d3b82c89-7b33-4873-ae04-53188e7cf126.png" alt="drawing" width="270px" />
<img src="https://user-images.githubusercontent.com/1846941/210210335-5f1ac48b-3671-4ddb-888d-67039e79a992.gif" alt="drawing" width="269px" /></br>
</p>


## 🛠 Dependencies
- [AndroidX Core KTX](https://developer.android.com/jetpack/androidx/releases/core#1.7.0): A set of Kotlin extension functions that are part of the Android KTX project.
- [AndroidX Lifecycle Runtime KTX](https://developer.android.com/jetpack/androidx/releases/lifecycle#2.3.1): Provides Kotlin extension functions for Lifecycle components.
- [AndroidX Activity Compose](https://developer.android.com/jetpack/compose/libraries#activity-compose): Simplifies the integration of Compose into existing activities and provides Compose-specific activity components.
- [AndroidX Compose UI](https://developer.android.com/jetpack/compose/ui): A library for creating user interfaces with Jetpack Compose.
- [AndroidX Compose Material](https://developer.android.com/jetpack/compose/material): A library for creating material design user interfaces with Jetpack Compose.
- [Coil](https://github.com/coil-kt/coil): An image loading library for Android backed by Kotlin Coroutines.
- [Coil Compose](https://github.com/coil-kt/coil/tree/master/coil-compose): A version of Coil that integrates with Jetpack Compose.
- [Coil GIF](https://github.com/coil-kt/coil/tree/master/coil-gif): A version of Coil that adds support for loading GIFs.
- [Retrofit](https://square.github.io/retrofit/): A type-safe HTTP client for Android and Java.
- [Kotlinx Serialization JSON](https://github.com/Kotlin/kotlinx.serialization): A Kotlin library for serialization and deserialization of JSON.
- [Retrofit Kotlinx Serialization Converter](https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter): A Retrofit converter that uses Kotlinx Serialization to serialize and deserialize request and response bodies.
- [OkHttp Logging Interceptor](https://square.github.io/okhttp/4.x/logging-interceptor/): An OkHttp interceptor that logs HTTP request and response data.
- [Koin](https://insert-koin.io/): A dependency injection framework for Kotlin.
- [Koin Android](https://insert-koin.io/docs/2.0/getting-started/android/): An extension of Koin that provides Android-specific features.
- [Koin AndroidX Compose](https://insert-koin.io/docs/2.0/getting-started/compose/): An extension of Koin that integrates with AndroidX Compose.


## License

Explain the terms under which your project can be used.

## Contact

A way for users to contact you if they have questions or want to report bugs.
