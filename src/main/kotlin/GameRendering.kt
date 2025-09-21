package io.github.cbaumont

import io.github.cbaumont.CLIColours.DEFAULT
import io.github.cbaumont.CLIColours.GREEN

interface GameRendering {
    fun renderGuess(guess: WordGuess): String
    fun readUserInput(): String
    fun showMessage(message: String): Unit

    companion object {
        fun cliRendering(): GameRendering = object : GameRendering {
            override fun renderGuess(guess: WordGuess): String = guess.matches.map {
                if (it.value) {
                    guess.value[it.key].green
                } else guess.value[it.key]
            }.joinToString(" ")

            override fun readUserInput(): String {
                return readln()
            }

            override fun showMessage(message: String) {
                println(message)
            }
        }
    }
}

enum class CLIColours(val code: String) {
    GREEN("\u001b[32m"),
    DEFAULT("\u001b[0m")
}

private val Char.green
    get() = "${GREEN.code}$this${DEFAULT.code}"