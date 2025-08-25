package io.github.cbaumont

@JvmInline
value class WordGuess(
    val value: String,
) {
    fun matches(correctWord: String): Map<Int, Boolean> {
        var acc = correctWord

        val result = mutableMapOf<Int, Boolean>()
        for (i in 0..<value.length) {
            if (value[i] in acc) {
                result[i] = true
                acc = acc.replaceFirst("${value[i]}", "", true)
            } else {
                result[i] = false
            }
        }

        return result
    }
}