data class WordGuess(
    val name: String,
) {
    fun matches(correctWord: String): Map<Int, Boolean> {
        var acc = correctWord

        val result = mutableMapOf<Int, Boolean>()
        for (i in 0..<name.length) {
            if (name[i] in acc) {
                result[i] = true
                acc = acc.replaceFirst("${name[i]}", "", true)
            } else {
                result[i] = false
            }
        }

        return result
    }
}