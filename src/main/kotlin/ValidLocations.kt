package io.github.cbaumont

fun String.findInValidLocations(validLocations: Collection<String>): Boolean = validLocations.contains(this)