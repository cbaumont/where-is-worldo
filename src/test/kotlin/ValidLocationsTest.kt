import io.github.cbaumont.findInValidLocations
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidLocationsTest {
    @Test
    fun `finds location word in list of locations`() {
        val location = "England"

        val result = location.findInValidLocations(setOf("England", "Porto Alegre", "China"))

        assertTrue(result)
    }

    @Test
    fun `does not find location word in list of locations`() {
        val location = "Brazil"

        val result = location.findInValidLocations(setOf("England", "Porto Alegre", "China"))

        assertFalse(result)
    }
}
