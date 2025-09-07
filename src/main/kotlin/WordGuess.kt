package io.github.cbaumont

data class WordGuess(
    val value: String,
    val correctWord: String
) {
    val matches: Map<Int, Boolean> by lazy {
        var matches = correctWord.uppercase()

        value
            .uppercase()
            .foldIndexed(mutableMapOf()) { i, acc, ch ->
                if (ch in matches) {
                    acc[i] = true
                    matches = matches.replaceFirst(ch, Char.MIN_VALUE, true)
                } else {
                    acc[i] = false
                }
                acc
            }
    }
    val fullMatch: Boolean = matches.values.all { it }
}