package me.imwalty.blowupcup.game

import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Vector2

abstract class Atom {
    abstract val texture: Texture
    abstract var position: Vector2
    abstract fun update()
    abstract fun draw(alpha: Double)
}