package me.imwalty.blowupcup.game.atom

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Vector2

class BlackstoneTile: Tile {
    override val texture: Texture
    override var position: Vector2

    constructor(position: Vector2) {
        this.texture = Texture.BLACKSTONE_TILE
        this.position = position
    }

    override fun update() {
        this.position.add(0.01, 0.01)
    }
    override fun draw(alpha: Double) {
        Game.instance.camera.draw(this.texture, this.position)
    }
}