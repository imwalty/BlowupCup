package me.imwalty.blowupcup.graphics

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JFrame

class CameraFrame: JFrame(), KeyListener, MouseListener {
    val keyboardInputs = mutableListOf<Char>()
    var isMousePressed = false

    init {
        this.isUndecorated = true
        this.extendedState = 6
        this.isResizable = false
        this.title = ""
        this.addKeyListener(this)
        this.addMouseListener(this)
        this.isVisible = true
    }

    override fun keyTyped(e: KeyEvent) {}

    override fun keyPressed(e: KeyEvent) {
        this.keyboardInputs.add(e.keyChar)
    }

    override fun keyReleased(e: KeyEvent) {
        this.keyboardInputs.remove(e.keyChar)
    }

    override fun mouseClicked(e: MouseEvent?) {}

    override fun mousePressed(e: MouseEvent?) {

    }

    override fun mouseReleased(e: MouseEvent?) {

    }

    override fun mouseEntered(e: MouseEvent?) {

    }

    override fun mouseExited(e: MouseEvent?) {

    }

}