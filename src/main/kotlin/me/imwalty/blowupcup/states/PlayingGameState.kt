package me.imwalty.blowupcup.states

import me.imwalty.blowupcup.Game

class PlayingGameState: GameState() {
    private var tick = 0
    private var frame = 0
    override fun initialize() {
        println("GameState.PLAYING initialized!")
    }

    override fun terminate() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun resume() {
        TODO("Not yet implemented")
    }

    override fun update() {
        Game.instance.world.atoms.forEach { atom ->
            atom.update()
        }
    }

    override fun draw(alpha: Double) {
        Game.instance.world.atoms.forEach { atom ->
            atom.draw(alpha)
        }
    }
}