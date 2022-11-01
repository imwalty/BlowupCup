package me.imwalty.blowupcup

import me.imwalty.blowupcup.game.World
import me.imwalty.blowupcup.game.atom.BlackstoneTile
import me.imwalty.blowupcup.game.atom.BouncingBall
import me.imwalty.blowupcup.graphics.Camera
import me.imwalty.blowupcup.manager.AssetManager
import me.imwalty.blowupcup.manager.PerformanceManager
import me.imwalty.blowupcup.states.GameState
import me.imwalty.gl.math.Vector2
import java.util.Stack

class Game {
    private val states: Stack<GameState>
    val delta: Double
    val camera: Camera
    val assetManager: AssetManager
    val performanceManager: PerformanceManager
    var isRunning: Boolean
    var world: World
    constructor(delta: Double) {
        this.delta = delta
        this.isRunning = true
        this.states = Stack<GameState>()
        this.camera = Camera(Vector2(0.0, -0.5), World(), 13.0)
        this.assetManager = AssetManager()
        this.performanceManager = PerformanceManager()
        this.world = World()
    }

    fun initialize() {
        Game.instance = this

        this.assetManager.initialize()

        this.pushState(GameState.PLAYING)

        for(y in 0 until 13) {
            for(x in 0 until 19) {
                this.world.spawn(BlackstoneTile(Vector2(x.toDouble(), y.toDouble())))
            }
        }

        this.world.spawn(BouncingBall(Vector2(5.0, 5.0)))
        this.world.spawn(BouncingBall(Vector2(6.0, 6.0)))


    }
    fun terminate() {

    }
    fun pushState(gameState: GameState) {
        gameState.initialize()
        this.states.push(gameState)
    }
    fun popState() {
        this.states.pop()
    }
    fun update() {
        this.states.peek().update(this, this.delta)
    }
    fun draw(alpha: Double) {
        this.performanceManager.registerFrame()
        this.states.peek().draw(this, this.delta, alpha)
        this.camera.render()
    }

    companion object {
        lateinit var instance: Game
    }
}