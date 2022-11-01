import me.imwalty.blowupcup.Game

@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) {
    val timePerTick = 20 // milliseconds per tick: 20 -> 50 t/s
    val game = Game(timePerTick / 1000.0)
    game.initialize()
    var previousTime = System.currentTimeMillis()
    var currentTime = 0L
    var frameTime = 0L
    var accTime = 0L
    while(game.isRunning) {
        currentTime = System.currentTimeMillis()
        frameTime = currentTime - previousTime
        previousTime = currentTime
        accTime += frameTime
        while(accTime >= timePerTick) {
            game.update()
            accTime -= timePerTick
        }
        game.draw(accTime.toDouble() / timePerTick)
    }
}