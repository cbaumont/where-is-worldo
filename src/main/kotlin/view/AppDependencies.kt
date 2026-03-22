package com.abacatogames.view

import com.abacatogames.geo.Distance
import com.abacatogames.geo.GeoLocation
import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies

fun Application.dependencies(geoDistance: (GeoLocation, GeoLocation) -> Distance) {
    dependencies {
        provide<WebView> { WebView.create(geoDistance) }
    }
}
