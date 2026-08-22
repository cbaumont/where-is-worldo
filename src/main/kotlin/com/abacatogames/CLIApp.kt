package com.abacatogames

import com.abacatogames.geo.toCountryName
import com.abacatogames.view.CLIView

fun main() {
    val game = Game(
        maxAttempts = 6,
        proposedWord = "GREENLAND",
        canonicalise = String::toCountryName
    )

    println(CLIView.create()(game))
    while (game.state != GameState.WON && game.state != GameState.LOST) {
        readln()
            .trim()
            .takeIf(String::isNotBlank)
            ?.let(game::validateAndAddGuess)
        println(CLIView.create()(game))
    }
}
