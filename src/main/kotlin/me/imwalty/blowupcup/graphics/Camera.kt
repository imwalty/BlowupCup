package me.imwalty.blowupcup.graphics

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.game.Atom
import me.imwalty.blowupcup.game.World
import me.imwalty.gl.math.IntVector2
import me.imwalty.gl.math.Rectangle
import me.imwalty.gl.math.Vector2
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class Camera {
    private val frame: CameraFrame
    private val screenOffset: IntVector2
    private val bufferedImage: BufferedImage
    private var graphics2D: Graphics2D
    private val pixelsPerUnit: Int
    val pixelsPerDot: Int
    val bounds: Rectangle
    var position: Vector2
    var velocity: Vector2
    var world: World
    /*
        @params
        position: world position of the camera in units
        world: world that is being displayed
        fov: world height of camera in units
     */
    constructor(position: Vector2, world: World, fov: Double) {
        this.frame = CameraFrame()
        this.position = position
        this.velocity = Vector2()
        this.bounds = Rectangle(this.frame.bounds.width.toDouble() / this.frame.bounds.height.toDouble() * fov, fov)
        this.pixelsPerDot = this.frame.bounds.height / (this.bounds.height * world.dotsPerUnit).toInt()
        this.pixelsPerUnit = this.pixelsPerDot * world.dotsPerUnit
        this.screenOffset = IntVector2(((this.frame.bounds.width - this.pixelsPerUnit * this.bounds.width) / 2).toInt(),
            ((this.frame.bounds.height - this.pixelsPerUnit * this.bounds.height) / 2).toInt())
        this.world = world
        this.frame.createBufferStrategy(1)
        this.bufferedImage = BufferedImage(this.frame.width, this.frame.height, BufferedImage.TYPE_INT_ARGB)
        this.graphics2D = this.bufferedImage.createGraphics()
    }

    fun render() {
        if(true) {
            val game = Game.instance
            val performanceManager = game.performanceManager
            this.graphics2D.drawString("Frames per Second: ${performanceManager.fps}", 5, 15)
            this.graphics2D.drawString("Seconds since Game Start: ${performanceManager.runtime}", 5, 30)
            this.graphics2D.drawString("", 5, 45)
            this.graphics2D.drawString("", 5, 60)
        }


        this.frame.graphics.drawImage(this.bufferedImage, 0, 0, null)
        this.graphics2D.clearRect(0, 0, this.frame.width, this.frame.height)
    }

    fun draw(texture: Texture, worldPosition: Vector2) {
        val screenPosition = this.worldPositionToScreenPosition(worldPosition)
        val bufferedImage = Game.instance.assetManager.getTexture(texture)
        this.graphics2D.drawImage(bufferedImage,
            screenPosition.x,
            screenPosition.y - bufferedImage.height,
            null)
    }

    private fun worldPositionToScreenPosition(worldPosition: Vector2): IntVector2 {
        return IntVector2(this.screenOffset.x + (this.pixelsPerUnit * worldPosition.x).toInt() - (this.pixelsPerUnit * this.position.x).toInt(),
                          this.screenOffset.y + ((this.pixelsPerUnit * worldPosition.y).toInt() - (this.pixelsPerUnit * this.position.y).toInt()) * -1 + this.frame.bounds.height)
    }
    private fun screenPositionToWorldPosition(screenPosition: IntVector2): Vector2 {
        return Vector2((screenPosition.x + (this.position.x * this.pixelsPerUnit) - this.screenOffset.x) / this.pixelsPerUnit,
                       (screenPosition.y + (this.position.y + this.pixelsPerUnit) - this.screenOffset.y) / this.pixelsPerUnit)
    }
}