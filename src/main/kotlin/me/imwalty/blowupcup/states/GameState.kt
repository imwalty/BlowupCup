package me.imwalty.blowupcup.states

import me.imwalty.blowupcup.Game

abstract class GameState {
    abstract fun initialize()
    abstract fun terminate()
    abstract fun pause()
    abstract fun resume()
    abstract fun update(game: Game, delta: Double)
    abstract fun draw(game: Game, delta: Double, alpha: Double)

    companion object {
        val PLAYING = PlayingGameState()
    }
}