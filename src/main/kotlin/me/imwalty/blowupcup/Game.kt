package me.imwalty.blowupcup

import me.imwalty.blowupcup.game.World
import me.imwalty.blowupcup.game.atom.BlackstoneTile
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
        this.camera = Camera(Vector2(0.0, 0.0), World(), 15.0)
        this.assetManager = AssetManager()
        this.performanceManager = PerformanceManager()
        this.world = World()
    }

    fun initialize() {
        Game.instance = this

        this.assetManager.initialize()

        this.pushState(GameState.PLAYING)


        val blackstoneTile = BlackstoneTile(Vector2(10.0 ,10.0))

        this.world.spawn(blackstoneTile)


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
        this.states.peek().update()
    }
    fun draw(alpha: Double) {
        this.performanceManager.registerFrame()
        this.states.peek().draw(alpha)
        this.camera.render()
    }

    companion object {
        lateinit var instance: Game
    }
}