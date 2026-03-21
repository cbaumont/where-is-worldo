import com.abacatogames.geo.randomCountry
import com.abacatogames.word.generateWordForDate
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class OneWordADayTest {
    val randomizer = ::randomCountry

    @Test
    fun `every day a new word is generated`() {
        val todaysWord = generateWordForDate(LocalDate.now(), randomizer)
        val tomorrowsWord = generateWordForDate(LocalDate.now().plusDays(1), randomizer)

        assertNotEquals(todaysWord, tomorrowsWord)
    }

    @Test
    fun `same day same word`() {
        val todaysWord = generateWordForDate(LocalDate.now(), randomizer)
        val todaysWordAgain = generateWordForDate(LocalDate.now(), randomizer)

        assertEquals(todaysWord, todaysWordAgain)
    }

}
