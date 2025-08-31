package io.github.cbaumont

fun main() {
    println(worldo)
    println("Where is Worldo today?")
    println("Start by making a guess: ")

    val correctWord = "ENGLAND"
    var guess = readln()

    var wordGuess = WordGuess(guess, correctWord)
    var fullMatch = wordGuess.fullMatch

    while (!fullMatch) {
        if (!guess.isLocationValid()) {
            println("Invalid location :(")
        } else {
            println(wordGuess.matches)
        }
        println("Make another guess: ")
        guess = readln()
        wordGuess = WordGuess(guess, correctWord)
        fullMatch = wordGuess.fullMatch
    }
    println("You won!")
}
