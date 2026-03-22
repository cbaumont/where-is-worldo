package com.abacatogames.word

import com.abacatogames.geo.randomCountry
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class OneWordADayTest {
    val wordGenerator = WordGenerator.create(::randomCountry)

    @Test
    fun `every day a new word is generated`() {
        val todaysWord = wordGenerator(LocalDate.now())
        val tomorrowsWord = wordGenerator(LocalDate.now().plusDays(1))

        assertNotEquals(todaysWord, tomorrowsWord)
    }

    @Test
    fun `same day same word`() {
        val todaysWord = wordGenerator(LocalDate.now())
        val todaysWordAgain = wordGenerator(LocalDate.now())

        assertEquals(todaysWord, todaysWordAgain)
    }

}
