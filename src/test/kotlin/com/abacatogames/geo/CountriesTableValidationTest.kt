package com.abacatogames.geo

import com.abacatogames.word.withoutDiacritics
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CountriesTableValidationTest {

    @Test
    fun `every ISO country is in the table under its own code`() {
        val byIso = CountriesTable.associateBy { it.iso }

        Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2).forEach { code ->
            val country = assertNotNull(byIso[code], "No table entry for ISO code $code")
            val displayName = Locale.Builder().setRegion(code).build().getDisplayCountry(Locale.ENGLISH)

            assertEquals(
                expected = renamedByCldr(displayName).toCountryKey(),
                actual = country.name.toCountryKey(),
                message = "$code: table has \"${country.name}\", JDK reports \"$displayName\""
            )
        }
    }

    @Test
    fun `table holds every ISO country plus Kosovo`() {
        val isoCodes = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2).toSet() + "XK"

        assertEquals(expected = isoCodes, actual = CountriesTable.map { it.iso }.toSet())
        assertEquals(expected = isoCodes.size, actual = CountriesTable.size)
    }

    @Test
    fun `no two countries share a match key`() {
        val keys = CountriesTable.map { it.name.toCountryKey() }

        assertEquals(expected = CountriesTable.size, actual = keys.toSet().size)
    }

    @Test
    fun `stripping diacritics preserves length`() {
        CountriesTable.forEach {
            assertEquals(
                expected = it.name.length,
                actual = it.name.withoutDiacritics().length,
                message = "\"${it.name}\" changes length when folded, which misaligns the board tiles"
            )
        }
    }

    @Test
    fun `coordinates are within range`() {
        CountriesTable.forEach {
            assertTrue(it.latitude in -90.0..90.0, "${it.name} latitude ${it.latitude}")
            assertTrue(it.longitude in -180.0..180.0, "${it.name} longitude ${it.longitude}")
        }
    }
}

private fun renamedByCldr(displayName: String): String =
    when (displayName) {
        "Cocos (Keeling) Islands" -> "Cocos Islands"
        "Congo - Brazzaville" -> "Republic of the Congo"
        "Congo - Kinshasa" -> "Democratic Republic of the Congo"
        "Hong Kong SAR China" -> "Hong Kong"
        "Macao SAR China" -> "Macau"
        "Myanmar (Burma)" -> "Myanmar"
        "Palestinian Territories" -> "Palestine"
        "United States" -> "United States of America"
        else -> displayName
    }.replace("St.", "Saint").replace("&", "and")
