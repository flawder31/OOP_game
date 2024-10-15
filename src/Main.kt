fun main() {
    println("Начало игры")

    // Get player names from the user
    print("Выбери имя для 1-го игрока: ")
    val player1Name = readLine() ?: "Player 1"

    print("Выбери имя для 2-го игрока: ")
    val player2Name = readLine() ?: "Player 2"

    // Create players based on user input
    println("\nВыбери своего персонажа: ")
    println("1. Human")
    println("2. Robot")
    println("3. Wizard")
    println("4. Knight")

    val choice1 = readLine()?.toIntOrNull()
    val choice2 = readLine()?.toIntOrNull()

    var player1 = when (choice1) {
        2 -> Robot(player1Name)
        3 -> Wizard(player1Name)
        4 -> Knight(player1Name)
        else -> Human(player1Name)
    }

    var player2 = when (choice2) {
        2 -> Robot(player2Name)
        3 -> Wizard(player2Name)
        4 -> Knight(player2Name)
        else -> Human(player2Name)
    }

    println("\nВ бой!\n$player1\n$player2")

    // Game loop
    while (player1.health > 0 && player2.health > 0) {
        println("\n${player1.name} ходит: ")
        println("1. Атака")
        println("2. Лечение")
        println("3. Специальная способность")
        val action1 = readLine()?.toIntOrNull()
        when (action1) {
            1 -> if (player1.attack(player2)) {
                println("${player2.name} повержен! ${player1.name} побеждает!")
                break
            }
            2 -> player1.heal()
            3 -> when (player1) {
                is Robot -> player1.chargeBattery(20)
                is Wizard -> player1.castSpell(player2)
                is Knight -> player1.blockAttack(player2)
                else -> println("Спецспособности отсутствуют.")
            }
            else -> println("Что-то пошло не так. Попробуй еще раз.")
        }

        // Switch turns
        var temp = player1
        player1 = player2
        player2 = temp

        println("\nТекущий статус:\n$player1\n$player2")
    }
}