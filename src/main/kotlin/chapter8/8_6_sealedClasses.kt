// Sealed classes are open for extension by other classes defined in
// the same file.

// In script files: ERROR - This type is sealed, so it can be inherited by only its own nested classes or objects
sealed class Card(val suit: String)

class Ace(suit: String): Card(suit)

class King(suit: String): Card(suit) {
    override fun toString() = "King of $suit"
}

class Queen(suit: String): Card(suit) {
    override fun toString() = "Queen of $suit"
}

class Jack(suit: String): Card(suit) {
    override fun toString() = "Jack of $suit"
}

class Pip(suit: String, val number: Int): Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}


// You can derive singleton objects from sealed classes


fun process(card: Card) = when (card) {
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main() {
    println(process(Ace("Diamond"))) // Ace of Diamond
    println(process(Queen("Clubs"))) // Queen of Clubs
    println(process(Pip("Spades", 2))) // 2 of Spades
    println(process(Pip("Hearts", 6))) // 6 of Hearts
}
