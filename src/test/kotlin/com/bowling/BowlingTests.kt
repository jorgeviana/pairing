package com.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BowlingTests {

    val game = Game()

    @Test
    fun `roll 20 times is a game `() {
        repeat(20) {
            game.roll(1)
        }

        assertThat(game.score()).isEqualTo(20)
    }

    @Test
    fun `roll with spare`() {
        // 1st frame, spare
        game.roll(6)
        game.roll(4)

        // 2nd frame
        game.roll(1)
        game.roll(0)

        repeat(16) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(12)
    }

    @Test
    fun `roll with strike`() {
        // 1st frame, strike
        game.roll(10)

        // 2nd frame
        game.roll(2)
        game.roll(3)

        // rest of the game: 8 frames with each having 2 rolls
        // perhaps the other tests should look like this one: repeat(10) and then having 2 rolls per frame
        repeat(8) {
            game.roll(0)
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(20)
    }
}