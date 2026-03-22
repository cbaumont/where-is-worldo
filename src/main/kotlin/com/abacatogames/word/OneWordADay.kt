package com.abacatogames.word

import java.time.LocalDate
import java.time.LocalTime.MIN
import java.time.ZoneOffset.UTC
import kotlin.random.Random

var lastUpdated: LocalDate = LocalDate.now()

fun interface WordGenerator : (LocalDate) -> String {
    companion object {
        fun create(randomizer: (Random) -> String) =
            WordGenerator { date ->
                if (date > lastUpdated) {
                    lastUpdated = date
                }
                randomizer(Random(lastUpdated.toEpochSecond(MIN, UTC)))
            }
    }
}
