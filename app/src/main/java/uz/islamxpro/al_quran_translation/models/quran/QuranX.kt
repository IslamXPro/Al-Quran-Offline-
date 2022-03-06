package uz.islamxpro.al_quran_translation.models.quran

import java.io.Serializable

data class QuranX(
    val chapter: Int,
    val text: String,
    val verse: Int
):Serializable