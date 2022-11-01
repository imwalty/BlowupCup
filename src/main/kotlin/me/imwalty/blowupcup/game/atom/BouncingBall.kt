package me.imwalty.blowupcup.game.atom

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.graphics.Texture
import me.imwalty.gl.math.Rectangle
import me.imwalty.gl.math.Vector2
import java.util.*

class BouncingBall(position: Vector2) : Entity(Texture.BOUNCING_BALL, position, Rectangle(0.75, 0.75), Vector2(Random().nextDouble(-10.0, 10.0), Random().nextDouble(-10.0, 10.0))) {
    override fun update(game: Game, delta: Double) {
        this.position.add(this.velocity.copy().multiply(delta))

        if(this.position.x < 1 || this.position.x + this.bounds.width > 18.0) this.velocity.multiply(-1.0, 1.0)
        if(this.position.y < 1 || this.position.y + this.bounds.height > 12.0) this.velocity.multiply(1.0, -1.0)
        this.previousPosition = this.position
    }
    override fun draw(game: Game, delta: Double, alpha: Double) {
        val interpolatedPosition = this.previousPosition.copy().add(this.position.copy().subtract(this.previousPosition).multiply(alpha))
        game.camera.draw(this.texture, interpolatedPosition)
    }
}