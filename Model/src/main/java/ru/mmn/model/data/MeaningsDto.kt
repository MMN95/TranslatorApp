package ru.mmn.translatorapp.model.data

import com.google.gson.annotations.SerializedName

class MeaningsDto(
    @field:SerializedName("translation") val translation: TranslationDto?,
    @field:SerializedName("imageUrl") val imageUrl: String?,
    @field:SerializedName("transcription") val transcription: String?
)