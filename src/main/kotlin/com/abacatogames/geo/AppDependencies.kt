package com.abacatogames.geo

import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies
import kotlin.random.Random

fun Application.dependencies() {
    dependencies {
        provide<GeoDistance> { GeoDistance.create() }
        provide<(String) -> Boolean> { String::isAValidCountry }
        provide<(Random) -> String> { ::randomCountry }
    }
}
