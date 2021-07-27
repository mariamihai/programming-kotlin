package chapter8.enums

//enum class Suit {
//    CLUBS, DIAMONDS, HEARTS, SPADES
//}

enum class Suit(val symbol: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665') {
        override fun display() = "${super.display()} $symbol"
    },
    SPADES('\u2660');

     open fun display() = "$symbol $name"
}

sealed class Card(val suit: Suit)

class Ace(suit: Suit): Card(suit)

class King(suit: Suit): Card(suit) {
    override fun toString() = "King of $suit"
}


class Queen(suit: Suit): Card(suit) {
    override fun toString() = "Queen of $suit"
}

class Jack(suit: Suit): Card(suit) {
    override fun toString() = "Jack of $suit"
}

class Pip(suit: Suit, val number: Int): Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}


fun process(card: Card) = when (card) {
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main() {
    println(process(Ace(Suit.DIAMONDS))) // Ace of DIAMONDS
    println(process(Queen(Suit.CLUBS))) // Queen of CLUBS
    println(process(Pip(Suit.SPADES, 2))) // 2 of SPADES
    println(process(Pip(Suit.HEARTS, 6))) // 6 of HEARTS

    val diamonds = Suit.valueOf("DIAMONDS")

    try {
        val random = Suit.valueOf("Invalid value.")
    } catch (exc: RuntimeException) {
        println("Invalid value.")
    }

//    for (suit in Suit.values()) {
//        println("${suit.name} -- ${suit.ordinal}") // CLUBS -- 0, etc.
//    }

    for (suit in Suit.values()) {
        println("${suit.display()}  --- ${suit.javaClass}")
    }
}
