import java.util.*
open class Human(val name: String, var health:Int = 100, var power:Int = 20){

    open fun attack(target: Human):Boolean{
        target.health-=power //отнимаем у цели ХП равное мощности атакующего
        println("$name атакует $target и наносит $power урона!") // выводим на экран результат атаки
        return target.health <= 0
    }

    fun heal(): Boolean {
        if (health < 100) {
            health += 20
            println("$name лечит себя и увеличивает здоровье на 20 очков!")
            return true
        } else {
            println("$name уже полностью излечен.")
            return false
        }
    }
    override open fun toString(): String {
        return "$name (Здоровье: $health), Сила: $power"
    }
}


