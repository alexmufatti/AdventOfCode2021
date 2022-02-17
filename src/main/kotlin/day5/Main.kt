package day5

import java.io.File
import java.lang.Math.abs
import java.lang.Math.max

class Map(size: Int) {
    var rows: Array<Array<Int>> = Array(size) { Array(size) { 0 } }

    fun print() {
        rows.forEach { row ->
            row.forEach {
                print("$it")
            }
            println()
        }
    }
}

fun main(args: Array<String>) {
    val fileName = "input5.txt"
    val scheda = Map(1000)

    File(fileName).readLines().map { row ->
        parseRow(row)
    }
        .forEach { line ->
            drawLine(line, scheda)
        }

    val danger = scheda.rows.map { it.count { it > 1 } }.sum()

    println(danger)
}

fun drawLine(line: List<Pair<Int, Int>>, scheda: Map) {
    println("${line[0].first},${line[0].second} -> ${line[1].first},${line[1].second}")

    val versoX = line[1].first.compareTo(line[0].first)
    val versoY = line[1].second.compareTo(line[0].second)

    val len = max(abs(line[0].first - line[1].first), abs(line[0].second - line[1].second))
    (0..len).forEachIndexed { idx, it ->
        scheda.rows[line[0].first + (idx * versoX)][line[0].second + (idx * versoY)] =
            scheda.rows[line[0].first + (idx * versoX)][line[0].second + (idx * versoY)] + 1
    }
}

fun parseRow(row: String): List<Pair<Int, Int>> {
    return row.split(" -> ").map {
        val n = it.split(",").map { it.toInt() }
        Pair(n[0], n[1])
    }
}
