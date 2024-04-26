package com.erenalparslan.dictionaryapp.presentation

import com.erenalparslan.dictionaryapp.domain.model.WordItem


data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)
