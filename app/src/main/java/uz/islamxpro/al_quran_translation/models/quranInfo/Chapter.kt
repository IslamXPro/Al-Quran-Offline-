package uz.islamxpro.al_quran_translation.models.quranInfo

import java.io.Serializable

data class Chapter(
    val arabicname: String,
    val chapter: Int,
    val englishname: String,
    val name: String,
    val revelation: String,
    val verses: List<Verse>
):Serializable