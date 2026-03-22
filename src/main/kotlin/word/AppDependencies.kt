package com.abacatogames.word

import io.ktor.server.application.Application
import io.ktor.server.plugins.di.dependencies
import kotlin.random.Random

fun Application.dependencies(randomizer: (Random) -> String) =
    dependencies {
        provide<WordGenerator> { WordGenerator.create(randomizer) }
    }
