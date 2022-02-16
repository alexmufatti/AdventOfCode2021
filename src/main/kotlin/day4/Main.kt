package day4

import java.io.File

class Scheda {
    var rows: MutableList<MutableList<Int>> = mutableListOf()

    fun print() {
        rows.forEach { row ->
            row.forEach {
                print("$it ")
            }
            println()
        }
    }
}

fun main(args: Array<String>) {
    val fileName = "input4.txt"
    var numbers = emptyList<Int>()
    val schede = mutableListOf<Scheda>()
    var scheda: Scheda? = null
    File(fileName).readLines().forEachIndexed { idx, row ->

        if (idx == 0) {
            numbers = row.split(",").map { it.toInt() }
        } else if (row == "") {
            if (scheda != null) schede.add(scheda!!)

            scheda = Scheda()
        } else {
            val row = row.split(" ").filter { it != "" }.map { it.toInt() }
            scheda!!.rows.add(row.toMutableList())
        }
    }

    numbers.forEach { num ->
        println("--------------------------------")
        println("Extracted $num")

        schede.forEach { scheda ->
            scheda.rows.forEach { row ->
                if (row.indexOf(num) >= 0) row[row.indexOf(num)] = -1
            }
        }

        val winnings = checkWin(schede)

        if (winnings.isNotEmpty()) {
            winnings.forEach {
                println("Scheda")
                it.print()
                println()
                println("risultato ${calc(it, num)}")
            }
        } else {
            println("No winnings")
        }

        winnings.forEach { schede.remove(it) }
        println("Lasting boards ${schede.count()}")
        println("--------------------------------")
    }
}

fun calc(scheda: Scheda, num: Int): Int {
    return scheda.rows.map {
        it.filter { it != -1 }.sum()
    }.sum() * num
}

fun checkWin(schede: MutableList<Scheda>): List<Scheda> {
    val ret = mutableListOf<Scheda>()
    schede.forEachIndexed { idxS, scheda ->
        scheda.rows.forEach { row ->
            if (row.sum() == -5) ret.add(scheda)
        }
    }

    (0..4).forEach { col ->
        schede.forEachIndexed { idxS, scheda ->
            if (scheda.rows.sumOf { it[col] } == -5) ret.add(scheda)
        }
    }
    return ret
}
