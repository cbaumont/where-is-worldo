package io.github.cbaumont

data class WordGuess(
    val value: String,
    val correctWord: String
) {
    val matches: Map<Int, Boolean>
        get() {
            val result = mutableMapOf<Int, Boolean>()
            var acc = correctWord.uppercase()
            val valueUpperCase = value.uppercase()

            for (i in 0..<valueUpperCase.length) {
                if (valueUpperCase[i] in acc) {
                    result[i] = true
                    acc = acc.replaceFirst("${valueUpperCase[i]}", "", true)
                } else {
                    result[i] = false
                }
            }
            return result
        }
    val fullMatch: Boolean by lazy { matches.values.all { it } }
}