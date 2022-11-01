package me.imwalty.blowupcup.game

class World {
    val dotsPerUnit: Int
    val atoms: MutableList<Atom>

    constructor() {
        this.dotsPerUnit = 12
        this.atoms = mutableListOf()
    }

    fun spawn(atom: Atom) {
        this.atoms.add(atom)
    }
    fun kill(atom: Atom) {
        this.atoms.remove(atom)
    }
}