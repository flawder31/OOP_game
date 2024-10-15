class Robot(name: String) : Human(name){
    var battery: Int = 50
    fun chargeBattery(amount: Int) :Boolean {
        if ((battery + amount) <= 100 ){
            battery += amount
            println("$name подзаряжается $amount%!")
            return true
        } else {
            println("Нельзя зарядиться больше, чем на 100%")
            return false
        }
    }
    override fun attack(target: Human): Boolean {
        if (battery>=90) {
            battery -= 30 // спецатака
            power *= 2
            target.health-=power
        } else {
            println("Недостаточно заряда для спецатаки.")
            target.health-=power // отнимаем у цели ХП равное мощности атакующего
        }

        println("$name aтакует $target и наносит $power урона") // выводим на экран результат атаки
        return target.health <= 0
    }
    override fun toString(): String {
        return super.toString() + " (Заряд батареи: $battery%)"
    }


}