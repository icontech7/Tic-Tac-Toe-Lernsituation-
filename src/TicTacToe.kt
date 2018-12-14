import java.util.*

var board = arrayOfNulls<String>(9)
private var gameField: String? = null
val gameSituation = arrayListOf<String>(
        "X", "", "",
        "O", "X", "X",
        "X", "X", "O")

fun main(args: Array<String>) {

    printBoard()
    val winner = evaluate()
    for (i in gameSituation) {

        if (i == "X" || i == "O") {
            gameField = "X"
            gameField = "O"
        } else {
            gameField = null
        }
    }



    println("ist es eine gültige Spielsituation ?")
    isValid(gameField)
    println("------------------------------------------")
    println(winner)

}

fun isValid(field: String?): Boolean {

    val isValid: Boolean = field == "X" || field == "O"
    println(isValid)

    return isValid
}


private fun evaluate(): String? {
    for (a in 0..7) {
        var line: String? = null
        when (a) {
            0 -> line = gameSituation[0] + gameSituation[1] + gameSituation[2]
            1 -> line = gameSituation[3] + gameSituation[4] + gameSituation[5]
            2 -> line = gameSituation[6] + gameSituation[7] + gameSituation[8]
            3 -> line = gameSituation[0] + gameSituation[3] + gameSituation[6]
            4 -> line = gameSituation[1] + gameSituation[4] + gameSituation[7]
            5 -> line = gameSituation[2] + gameSituation[5] + gameSituation[8]
            6 -> line = gameSituation[0] + gameSituation[4] + gameSituation[8]
            7 -> line = gameSituation[2] + gameSituation[4] + gameSituation[6]
        }
        if (line == "XXX") {
            return "Der Spieler (X) hat gewonnen."
        } else if (line == "OOO") {
            return "Der Spieler (O) hat gewonnen."
        }
    }
    for (a in 0..8) {
        if (Arrays.asList<String>(*board).contains((a + 1).toString())) {
            break
        } else if (a == 8) return "Das Spiel endete mit einem Unentschieden."
    }
    return null
}

private fun printBoard() {
    println("/---|---|---\\")
    println("| " + gameSituation[0] + " | " + gameSituation[1] + " | " + gameSituation[2] + " |")
    println("|-----------|")
    println("| " + gameSituation[3] + " | " + gameSituation[4] + " | " + gameSituation[5] + " |")
    println("|-----------|")
    println("| " + gameSituation[6] + " | " + gameSituation[7] + " | " + gameSituation[8] + " |")
    println("/---|---|---\\")
}


/*
  val isNotValid: Boolean = isItOk.isEmpty()
    val text: String

    text = if (isNotValid) {
        "ungültige"
    } else {
        "gültige"
    }
    println("es ist ein $text Spielsituation, spieler $Player hat(${isItOk.size} mal $Player)eingegeben")


    println(!isNotValid)
    return !isNotValid
 */