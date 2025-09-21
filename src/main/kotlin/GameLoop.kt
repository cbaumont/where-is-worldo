package io.github.cbaumont

class GameLoop(
    val gameRendering: GameRendering,
    val wordOfTheDay: String,
    gameIntro: String = "$worldo\nWhere is Worldo today?\nStart by making a guess: "
) {
    init {
        gameRendering.showMessage(gameIntro)
    }

    fun mainLoop() {
        var guess = gameRendering.readUserInput()

        var wordGuess = WordGuess(guess, wordOfTheDay)
        var fullMatch = wordGuess.fullMatch

        while (!fullMatch) {
            if (!guess.isLocationValid()) {
                gameRendering.showMessage("Invalid location :(")
            } else {
                gameRendering.showMessage(gameRendering.renderGuess(wordGuess))
            }
            gameRendering.showMessage("Make another guess: ")
            guess = gameRendering.readUserInput()
            wordGuess = WordGuess(guess, wordOfTheDay)
            fullMatch = wordGuess.fullMatch
        }
        gameRendering.showMessage(gameRendering.renderGuess(wordGuess))
        gameRendering.showMessage("You won!")
    }
}
