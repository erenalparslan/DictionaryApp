package com.erenalparslan.dictionaryapp.data.repository

import android.app.Application
import com.erenalparslan.dictionaryapp.domain.model.WordItem
import com.erenalparslan.dictionaryapp.R
import com.erenalparslan.dictionaryapp.data.api.DictionaryApi
import com.erenalparslan.dictionaryapp.data.mapper.toWordItem
import com.erenalparslan.dictionaryapp.domain.repository.DictionaryRepository
import com.erenalparslan.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {
    override suspend fun getWord(word: String): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))
            var remoteWordResultDto = try {
                dictionaryApi.getWord(word)
            } catch (e: Exception) {
                emit(Result.Error(e.stackTraceToString()))
                emit(Result.Loading(false))
                e.stackTraceToString()
                return@flow
            }
            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Error(application.getString(R.string.can_t_get_result)))
            emit(Result.Loading(false))
        }
    }
}