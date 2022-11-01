package me.imwalty.blowupcup.states

abstract class GameState {
    abstract fun initialize()
    abstract fun terminate()
    abstract fun pause()
    abstract fun resume()
    abstract fun update()
    abstract fun draw(alpha: Double)

    companion object {
        val PLAYING = PlayingGameState()
    }
}