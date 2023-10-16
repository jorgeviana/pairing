package com.bowling

class Game {
    private val rolls = mutableListOf<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var i = 0

        while (i < rolls.size - 1) {
            val first = rolls[i]
            val second = rolls[i + 1]

            if (isStrike(first)) {
                score += first
                score += rolls[i + 1]
                score += rolls[i + 2]
                i++
            }
            else if (isSpare(first, second)) {
                score += first + second
                score += rolls[i + 2]
                i += 2
            }
            else {
                score += first + second
                i += 2
            }
        }
        return score
    }

    private fun isStrike(first: Int): Boolean {
        return first == 10
    }

    private fun isSpare(first: Int, second: Int): Boolean {
        return first + second == 10
    }
}