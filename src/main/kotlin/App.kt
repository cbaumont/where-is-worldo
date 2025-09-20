package io.github.cbaumont

fun main() {
    GameLoop(
        gameRendering = GameRendering.cliRendering(),
        wordOfTheDay = "ENGLAND",
    ).mainLoop()
}
