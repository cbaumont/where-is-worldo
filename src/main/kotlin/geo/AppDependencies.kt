package com.abacatogames.geo

import com.abacatogames.word.Randomizer
import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies

fun Application.dependencies() {
    dependencies {
        provide<GeoDistance> { GeoDistance.create() }
        provide<(String) -> Boolean> { String::isAValidCountry }
        provide<Randomizer> { ::randomCountry }
    }
}
