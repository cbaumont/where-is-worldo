package com.abacatogames.geo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CountryMatchingTest {

    @Test
    fun `accepts names typed without their accents`() {
        assertEquals("Curaçao", "curacao".toCountryName())
        assertEquals("Åland Islands", "aland islands".toCountryName())
        assertEquals("Réunion", "REUNION".toCountryName())
        assertEquals("São Tomé and Príncipe", "sao tome and principe".toCountryName())
        assertEquals("Saint Barthélemy", "SAINT BARTHELEMY".toCountryName())
        assertEquals("Türkiye", "Turkiye".toCountryName())
    }

    @Test
    fun `accepts names typed with their accents`() {
        assertEquals("Curaçao", "Curaçao".toCountryName())
        assertEquals("Åland Islands", "Åland Islands".toCountryName())
        assertEquals("Türkiye", "türkiye".toCountryName())
    }

    @Test
    fun `accepts names typed with different accents than we store`() {
        assertEquals("Côte d'Ivoire", "Cote d'Ivoire".toCountryName())
        assertEquals("Côte d'Ivoire", "Côte d'Ivoire".toCountryName())
        assertEquals("Côte d'Ivoire", "Côte d’Ivoire".toCountryName())
    }

    @Test
    fun `ignores punctuation and repeated whitespace`() {
        assertEquals("Côte d'Ivoire", "cote divoire".toCountryName())
        assertEquals("United Kingdom", "United  Kingdom".toCountryName())
        assertEquals("Guinea-Bissau", "guinea bissau".toCountryName())
        assertEquals("Timor-Leste", "TIMOR LESTE".toCountryName())
    }

    @Test
    fun `does not match names that differ by more than accents`() {
        assertNull("Turkey".toCountryName())
        assertNull("Ivory Coast".toCountryName())
        assertNull("Xique-xique".toCountryName())
    }

    @Test
    fun `resolves coordinates through the same matching`() {
        assertEquals(Country.of("Curaçao"), Country.of("curacao"))
        assertEquals(Country.of("Côte d'Ivoire"), Country.of("cote divoire"))
    }
}
