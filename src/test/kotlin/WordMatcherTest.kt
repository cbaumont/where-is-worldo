import io.github.cbaumont.WordGuess
import kotlin.test.Test
import kotlin.test.assertEquals

class WordMatcherTest {

    @Test
    fun `some letters in the word match`() {
        val correctWord = "ENGLAND"

        val guess = WordGuess(
            value = "GREENLAND",
        )

        val expected = mapOf(
            0 to true,
            1 to false,
            2 to true,
            3 to false,
            4 to true,
            5 to true,
            6 to true,
            7 to true,
            8 to true,
        )
        assertEquals(expected, guess.matches(correctWord))
    }
}

