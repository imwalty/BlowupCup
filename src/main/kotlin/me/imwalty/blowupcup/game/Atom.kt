package me.imwalty.blowupcup.game

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Rectangle
import me.imwalty.gl.math.Vector2

abstract class Atom {
    val texture: Texture
    val bounds: Rectangle
    var position: Vector2
    constructor(texture: Texture, position: Vector2, bounds: Rectangle) {
        this.texture = texture
        this.position = position
        this.bounds = bounds
    }
    abstract fun update(game: Game, delta: Double)
    abstract fun draw(game: Game, delta: Double, alpha: Double)
}