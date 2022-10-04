package com.example.getten
object CardDeck {
    fun drawCard(): Card {
        var value = (1..9).random()
        var card = Card(value)

        return card
    }
}
