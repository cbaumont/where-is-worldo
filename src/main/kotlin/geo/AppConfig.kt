package com.abacatogames.geo

import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies

fun Application.geoDistance() {
    dependencies {
        provide { GeoDistance.create() }
    }
}