package com.abacatogames.word

@JvmInline
value class VerifiedWord internal constructor(val value: String) {

    companion object {
        fun of(rawValue: String?, canonicalise: (String) -> String?): VerifiedWord? =
            rawValue
                ?.let(canonicalise)
                ?.let { VerifiedWord(it) }
    }
}
