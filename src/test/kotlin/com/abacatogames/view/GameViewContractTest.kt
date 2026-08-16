package com.abacatogames.view

import com.abacatogames.Game
import com.abacatogames.geo.toCountryName
import kotlin.test.Test
import kotlin.test.assertContains

abstract class GameViewContractTest(val gameView: (Game) -> String) {
    @Test
    fun `new game displays correct game instructions`() {
        val game = Game(
            maxAttempts = 3,
            proposedWord = "GREENLAND",
            canonicalise = { it }
        )

        assertContains(gameView(game), "Take a guess, any country will do!")
    }

    @Test
    fun `in progress game displays correct game instructions`() {
        val game = Game(
            maxAttempts = 3,
            proposedWord = "GREENLAND",
            canonicalise = { it }
        )

        game.validateAndAddGuess("GUYANA")

        assertContains(gameView(game), "You have 2 attempts left. Make another guess.")
    }

    @Test
    fun `invalid guess displays correct game instructions`() {
        val game = Game(
            maxAttempts = 3,
            proposedWord = "GREENLAND",
            canonicalise = String::toCountryName
        )

        game.validateAndAddGuess("GUESS")

        assertContains(gameView(game), "Invalid country, please make another guess.")
    }

    @Test
    fun `game won displays correct game instructions`() {
        val game = Game(
            maxAttempts = 3,
            proposedWord = "GREENLAND",
            canonicalise = { it }
        )

        game.validateAndAddGuess("GREENLAND")

        assertContains(gameView(game), "Congratulations, you found Wordo!")
    }

    @Test
    fun `game lost displays correct game instructions`() {
        val game = Game(
            maxAttempts = 1,
            proposedWord = "GREENLAND",
            canonicalise = { it }
        )

        game.validateAndAddGuess("GUYANA")

        assertContains(gameView(game), "You’re out of attempts for today — better luck tomorrow!")
    }

}
