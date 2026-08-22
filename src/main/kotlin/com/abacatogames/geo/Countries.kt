package com.abacatogames.geo

import com.abacatogames.word.withoutDiacritics
import kotlin.random.Random

private val NonAlphanumeric = Regex("[^A-Z0-9]")

fun String.toCountryKey(): String =
    withoutDiacritics().uppercase().replace(NonAlphanumeric, "")

fun String.toCountryName(): String? = CountriesByKey[toCountryKey()]?.name

fun randomCountry(random: Random): String = CountryNames.random(random)

private val CountriesByKey: Map<String, Country> = CountriesTable.associateBy { it.name.toCountryKey() }

private val CountryNames: Set<String> = CountriesTable.map { it.name }.toSortedSet()

sealed interface GeoLocation {
    val name: String
    val latitude: Double
    val longitude: Double
}

data class Country(
    val iso: String,
    override val name: String,
    override val latitude: Double,
    override val longitude: Double,
) : GeoLocation {
    companion object {
        fun of(name: String): Country =
            CountriesByKey[name.toCountryKey()] ?: error("Invalid country name.")
    }
}
