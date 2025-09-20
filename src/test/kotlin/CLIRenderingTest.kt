import io.github.cbaumont.CLIColours
import io.github.cbaumont.GameRendering
import io.github.cbaumont.WordGuess
import kotlin.test.Test
import kotlin.test.assertEquals

class CLIRenderingTest {

    @Test
    fun `renders correct matches in green`() {
        val gameRendering = GameRendering.cliRendering()

        val guess = WordGuess(
            value = "GUESS",
            correctWord = "GLASS"
        )

        val result = gameRendering.render(guess)

        val expected = "${CLIColours.GREEN.code}G${CLIColours.DEFAULT.code} U E " +
                "${CLIColours.GREEN.code}S${CLIColours.DEFAULT.code} " +
                "${CLIColours.GREEN.code}S${CLIColours.DEFAULT.code}"

        assertEquals(expected, result)
    }

}