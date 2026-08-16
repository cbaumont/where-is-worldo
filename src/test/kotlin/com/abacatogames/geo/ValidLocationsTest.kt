package com.abacatogames.geo

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidLocationsTest {
    @Test
    fun `finds location word in list of locations`() {
        val location = "Brazil"

        val result = location.isAValidCountry()

        assertTrue(result)
    }

    @Test
    fun `does not find location word in list of locations`() {
        val location = "Xique-xique"

        val result = location.isAValidCountry()

        assertFalse(result)
    }

    @Test
    fun `finds location word regardless of accents`() {
        assertTrue("curacao".isAValidCountry())
        assertTrue("Curaçao".isAValidCountry())
        assertTrue("Côte d'Ivoire".isAValidCountry())
        assertTrue("cote divoire".isAValidCountry())
    }
}
