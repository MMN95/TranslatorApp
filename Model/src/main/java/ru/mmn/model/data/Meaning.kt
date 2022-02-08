package ru.mmn.model.data

data class Meaning(
    val translatedMeaning: TranslatedMeaning = TranslatedMeaning(),
    val imageUrl: String = "",
    val transcription: String? = ""
)