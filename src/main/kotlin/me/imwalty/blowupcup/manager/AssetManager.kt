package me.imwalty.blowupcup.manager

import me.imwalty.blowupcup.Game
import me.imwalty.blowupcup.graphics.Texture
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class AssetManager: Manager() {
    private val textures = mutableMapOf<Texture, BufferedImage>()
    override fun initialize() {
        try {
            this.textures.put(Texture.BLACKSTONE_TILE, this.scaleBufferedImage(ImageIO.read(File("assets/textures/atoms/tiles/blackstone_tile.png"))))
        } catch (_: Error) {}
    }
    override fun terminate() {
        TODO("Not yet implemented")
    }
    fun getTexture(texture: Texture): BufferedImage {
        return this.textures[texture]!!
    }
    private fun scaleBufferedImage(bufferedImage: BufferedImage): BufferedImage {
        val scaledBufferedImage = BufferedImage(bufferedImage.width * Game.instance.camera.pixelsPerDot,
            bufferedImage.height * Game.instance.camera.pixelsPerDot,
            BufferedImage.TYPE_INT_ARGB)
        for(y in 0 until bufferedImage.height) {
            for(x in 0 until bufferedImage.width) {
                val color = bufferedImage.getRGB(x, y)
                val x1 = x * Game.instance.camera.pixelsPerDot
                val y1 = y * Game.instance.camera.pixelsPerDot
                for(y2 in 0 until Game.instance.camera.pixelsPerDot) {
                    for(x2 in 0 until Game.instance.camera.pixelsPerDot) {
                        scaledBufferedImage.setRGB(x1+ x2, y1 + y2, color)
                    }
                }
            }
        }
        return scaledBufferedImage
    }

}