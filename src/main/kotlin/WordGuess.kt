package io.github.cbaumont

data class WordGuess(
    val value: String,
    val correctWord: String = ""
) {
    val matches: MutableMap<Int, Boolean> = mutableMapOf()
    val fullMatch: Boolean
        get() = matches.values.all { it }


    init {
        var acc = correctWord

        for (i in 0..<value.length) {
            if (value[i] in acc) {
                matches[i] = true
                acc = acc.replaceFirst("${value[i]}", "", true)
            } else {
                matches[i] = false
            }
        }
    }

}