package io.github.cbaumont

import io.github.cbaumont.CLIColours.*

fun interface GameRenderer {
    fun render(guess: WordGuess): String

    companion object {
        fun cliRenderer(): GameRenderer = GameRenderer { guess ->
            guess.matches.map {
                if (it.value) {
                    guess.value[it.key].green
                }
                else guess.value[it.key]
            }.joinToString(" ")
        }
    }
}

enum class CLIColours(val code: String) {
    GREEN("\u001b[32m"),
    DEFAULT("\u001b[0m")
}

private val Char.green
    get() = "${GREEN.code}$this${DEFAULT.code}"