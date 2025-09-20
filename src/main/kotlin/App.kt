package io.github.cbaumont

fun main() {
    GameLoop(
        gameRenderer = GameRenderer.cliRenderer(),
        wordOfTheDay = "ENGLAND",
    ).mainLoop()
}
