package me.imwalty.blowupcup.game.atom

import me.imwalty.blowupcup.game.Atom
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Rectangle
import me.imwalty.gl.math.Vector2

abstract class Tile: Atom {
    constructor(texture: Texture, position: Vector2): super(texture, position, Rectangle(1.0, 1.0))
}