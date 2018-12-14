import java.util.*


/**
 * Lernsituation Tic-Tac-toe
 *
 * @author Ahmad afa alrefaey
 */


private var board = arrayOfNulls<String>(9)
private var positive = arrayListOf<String>()
private var negative = arrayListOf<String>()
private val gameSituation = arrayListOf<String>(
        "X", "O", "O",
        "O", "X", "X",
        "X", "X", "O")

fun main(args: Array<String>) {

    printBoard()
    val winner = evaluate()


    for (i in gameSituation) {

        if (i == "X" || i == "O") {
            positive.add(i)
        } else {
            negative.add(i)
        }
    }

    println("Ist es eine gültige Spielfelden ?")
    isValid(negative)
    println("------------------------------------------")
    println(winner)
    println("------------------------------------------")


}

/**
 * isValid method to check if the input are right.
 *
 * @param negative to get all the inputs that's not right.
 * @return true when the input is right.
 */
fun isValid(negative: ArrayList<String>): Boolean? {
    var isValid: Boolean? = null

    if (negative.isEmpty()) {
        println("ja, gültige Spielfelden")
        isValid = true
    } else if (negative.isNotEmpty()) {
        println("Nein, ungültige Spielfelden bitte geben Sie Nur X oder O ein")
        isValid = false

    }
    return isValid
}

/**
 * evaluate method to check the Winner.
 *
 * @return the Result of the Game as Text.
 */
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
            return "*.Der Spieler (X) hat gewonnen.*"
        } else if (line == "OOO") {
            return "*.Der Spieler (O) hat gewonnen.*"
        }
    }
    for (a in 0..8) {
        if (Arrays.asList<String>(*board).contains((a + 1).toString())) {
            break
        } else if (a == 8) return "*.Das Spiel endete mit einem Unentschieden.*"
    }
    print("*.Das Spiel ist noch nicht entschieden.*")
    return null
}

/**
 * printBoard method to print Board around the input.
 */
private fun printBoard() {
    println("/---|---|---\\")
    println("| " + gameSituation[0] + " | " + gameSituation[1] + " | " + gameSituation[2] + " |")
    println("|-----------|")
    println("| " + gameSituation[3] + " | " + gameSituation[4] + " | " + gameSituation[5] + " |")
    println("|-----------|")
    println("| " + gameSituation[6] + " | " + gameSituation[7] + " | " + gameSituation[8] + " |")
    println("/---|---|---\\")
}