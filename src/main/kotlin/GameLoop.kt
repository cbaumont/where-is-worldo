package io.github.cbaumont

class GameLoop(
    val gameRenderer: GameRenderer,
    val wordOfTheDay: String,
    gameIntro: String = "$worldo\nWhere is Worldo today?\nStart by making a guess: "
) {
    init {
        println(gameIntro)
    }

    fun mainLoop() {
        var guess = readln()

        var wordGuess = WordGuess(guess, wordOfTheDay)
        var fullMatch = wordGuess.fullMatch

        while (!fullMatch) {
            if (!guess.isLocationValid()) {
                println("Invalid location :(")
            } else {
                println(gameRenderer.render(wordGuess))
            }
            println("Make another guess: ")
            guess = readln()
            wordGuess = WordGuess(guess, wordOfTheDay)
            fullMatch = wordGuess.fullMatch
        }
        println(gameRenderer.render(wordGuess))
        println("You won!")
    }
}
