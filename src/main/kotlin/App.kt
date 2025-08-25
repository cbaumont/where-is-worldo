package io.github.cbaumont

fun main() {
    println(worldo)
    println("Where is Worldo today?")
    println("Start by making a guess:")
    val guess = readln()

    if (guess.isLocationValid()) {
        println("Location is valid!")
    }
    else {
        println("Invalid location :(")
    }
}
