package me.imwalty.blowupcup.game.atom

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Vector2

class BlackstoneTile: Tile {
    constructor(position: Vector2): super(Texture.BLACKSTONE_TILE, position)

    override fun update(game: Game, delta: Double) {
    }
    override fun draw(game: Game, delta: Double, alpha: Double) {
        game.camera.draw(this.texture, this.position)
    }
}