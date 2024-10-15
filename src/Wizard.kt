class Wizard(name: String) : Human(name) {
    var mana: Int = 75

    fun castSpell(target: Human): Boolean {
        if (mana >= 20) {
            mana -= 20
            target.health -= 30
            println("$name произносит заклинание на $target и наносит 30 урона!")
            return target.health <= 0
        } else {
            println("$name не хватает маны для заклинания!")
            return false
        }
    }

    override fun toString(): String {
        return super.toString() + " (Мана: $mana)"
    }
}
