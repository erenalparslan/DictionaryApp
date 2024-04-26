package com.erenalparslan.dictionaryapp.domain.repository

import com.erenalparslan.dictionaryapp.domain.model.WordItem
import com.erenalparslan.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {

    suspend fun getWord(word:String): Flow<Result<WordItem>>
}