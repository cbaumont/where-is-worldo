import io.github.cbaumont.GameLoop
import io.github.cbaumont.GameRendering
import io.github.cbaumont.WordGuess
import kotlin.test.Test
import kotlin.test.assertNotEquals

class GameLoopTest {

    @Test
    fun `game loop test`() {
        val gameRendering = SpyRendering("TEST")
        val gameLoop = GameLoop(
            gameRendering = gameRendering,
            wordOfTheDay = "TEST",
        )

        gameLoop.mainLoop()

        assertNotEquals("You won!", gameRendering.message)
    }
}

private class SpyRendering(
    var userInput: String,
    var message: String = ""
) : GameRendering {
    override fun renderGuess(guess: WordGuess): String = guess.value
    override fun readUserInput(): String = userInput
    override fun showMessage(message: String) {
        this.message = message
    }
}
