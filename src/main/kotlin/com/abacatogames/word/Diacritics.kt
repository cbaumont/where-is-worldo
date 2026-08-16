package com.abacatogames.word

import java.text.Normalizer

private val CombiningMarks = Regex("\\p{Mn}")

fun String.withoutDiacritics(): String =
    Normalizer.normalize(this, Normalizer.Form.NFD).replace(CombiningMarks, "")
