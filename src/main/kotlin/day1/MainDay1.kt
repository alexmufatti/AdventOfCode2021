package day1
import java.io.File

val fileName = "input2.txt"

fun main(args: Array<String>) {

    var prevValue:Int? = null

    val ret = File(fileName).readLines().fold(SubmarineData(0,0, 0)) { acc, value ->
        val direction = value.split(" ")[0].trim()
        val x = value.split(" ")[1].trim().toInt()
        when (direction) {
            "forward" -> SubmarineData(acc.horizontal + x, acc.depth + (acc.aim * x), acc.aim)
            "down" -> SubmarineData(acc.horizontal, acc.depth, acc.aim + x)
            "up" -> SubmarineData(acc.horizontal, acc.depth, acc.aim - x)
            else -> acc
        }
    }

    println(ret.horizontal * ret.depth)
}

data class SubmarineData (val horizontal:Int, val depth:Int, val aim: Int)
