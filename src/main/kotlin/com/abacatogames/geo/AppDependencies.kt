package com.abacatogames.geo

import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies
import kotlin.random.Random

fun Application.dependencies() {
    dependencies {
        provide<GeoDistance> { GeoDistance.create() }
        provide<(String) -> String?> { String::toCountryName }
        provide<(Random) -> String> { ::randomCountry }
    }
}
