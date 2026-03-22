package com.abacatogames.word

import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies

fun Application.dependencies() =
    dependencies {
        provide<WordGenerator> { ::generateWordForDate }
    }
