package com.erenalparslan.dictionaryapp.data.api

import com.erenalparslan.dictionaryapp.data.dto.WordResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("{word}")
    suspend fun getWord(@Path("word") word: String): WordResultDto

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }
}