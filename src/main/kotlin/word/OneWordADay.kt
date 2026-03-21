package com.abacatogames.word

import java.time.LocalDate
import java.time.LocalTime.MIN
import java.time.ZoneOffset.UTC
import kotlin.random.Random

var lastUpdated: LocalDate = LocalDate.now()
fun generateWordForDate(
    date: LocalDate,
    randomizer: Randomizer
): String {
    if (date > lastUpdated) {
        lastUpdated = date
    }
    return randomizer(Random(lastUpdated.toEpochSecond(MIN, UTC)))
}

typealias Randomizer = (Random) -> String
typealias WordGenerator = (LocalDate, Randomizer) -> String
