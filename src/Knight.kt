class Knight(name: String) : Human(name) {
    var protection: Int = 10

    fun blockAttack(attacker: Human): Boolean {
        val blockedDamage = attacker.power / 2
        attacker.health -= blockedDamage
        health += blockedDamage
        println("$name блокирует атаку $attacker и уменьшает урон на $blockedDamage!")
        return attacker.health <= 0
    }

    override fun toString(): String {
        return super.toString() + " (Защита: $protection)"
    }
}