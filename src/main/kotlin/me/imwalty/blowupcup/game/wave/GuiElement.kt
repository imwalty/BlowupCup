package me.imwalty.blowupcup.game.wave

import me.imwalty.blowupcup.Game
import me.imwalty.gl.math.Vector2

abstract class GuiElement {
    abstract var position: Vector2
    abstract var origin: GuiElementOrigin
    abstract fun update(game: Game, delta: Double)
    abstract fun draw(game: Game, delta: Double, alpha: Double)
}