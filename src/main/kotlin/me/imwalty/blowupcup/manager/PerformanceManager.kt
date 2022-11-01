package me.imwalty.blowupcup.manager

class PerformanceManager {
    private val gameStartMillis: Long
    private var secondStartMillis: Long
    private var frames: Int
    var fps: Int
    val runtime: Double
        get() = (System.currentTimeMillis() - this.gameStartMillis) / 1000.0

    constructor() {
        this.gameStartMillis = System.currentTimeMillis()
        this.secondStartMillis = this.gameStartMillis
        this.frames = 0
        this.fps = 0
    }

    fun registerFrame() {
        this.frames++
        if(System.currentTimeMillis() > this.secondStartMillis + 1000) { // executes once a second
            this.fps = this.frames
            this.frames = 0
            this.secondStartMillis = System.currentTimeMillis()
            System.gc()
        }
    }


}