package com.abacatogames.view

import com.abacatogames.geo.GeoDistance
import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies

fun Application.dependencies(geoDistance: GeoDistance) {
    dependencies {
        provide { WebView.create(geoDistance) }
    }
}
