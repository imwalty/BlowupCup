package me.imwalty.blowupcup.game.atom

import me.imwalty.blowupcup.game.Atom
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Rectangle
import me.imwalty.gl.math.Vector2
import java.awt.image.BufferedImage

abstract class Entity: Atom {
    var velocity: Vector2
    var previousPosition: Vector2
    constructor(texture: Texture, position: Vector2, bounds: Rectangle, velocity: Vector2): super(texture, position, bounds) {
        this.velocity = velocity
        this.previousPosition = this.position
    }
}