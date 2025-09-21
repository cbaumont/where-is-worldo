import io.github.cbaumont.GameLoop
import io.github.cbaumont.GameRendering
import io.github.cbaumont.WordGuess
import kotlin.test.Test
import kotlin.test.assertFails

class GameLoopTest {

    @Test
    fun `invalid location is not allowed as word of the day`() {
        assertFails("Unable to start game: invalid location") {
            GameLoop(
                gameRendering = SpyRendering(),
                proposedWord = "TEST",
            )
        }
    }

}

private class SpyRendering(
    var userInput: String = "",
    var message: String = ""
) : GameRendering {
    override fun renderGuess(guess: WordGuess): String = guess.value
    override fun readUserInput(): String = userInput
    override fun showMessage(message: String) {
        this.message = message
    }
}
