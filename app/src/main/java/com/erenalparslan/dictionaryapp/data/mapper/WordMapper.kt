package com.erenalparslan.dictionaryapp.data.mapper

import com.erenalparslan.dictionaryapp.domain.model.Definition
import com.erenalparslan.dictionaryapp.domain.model.Meaning
import com.erenalparslan.dictionaryapp.domain.model.WordItem
import com.erenalparslan.dictionaryapp.data.dto.DefinitionDto
import com.erenalparslan.dictionaryapp.data.dto.MeaningDto
import com.erenalparslan.dictionaryapp.data.dto.WordItemDto


fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)
