package day1
import java.io.File

val fileName = "input3.txt"

fun main(args: Array<String>) {



    var readLines = File(fileName).readLines()


    for (i in 0..11) {
        val result = getMostFrequentBit(readLines, i)
        readLines = readLines.filter { it -> it[i].digitToInt() == result }
        if (readLines.count() <= 1) break
    }
    val oxygen = readLines[0]

    readLines = File(fileName).readLines()



    for (i in 0..11) {
        val result = getLessFrequentBit(readLines, i)
        readLines = readLines.filter { it -> it[i].digitToInt() == result }
        if (readLines.count() <= 1) break
    }
    val co2 = readLines[0]

    println(convert(oxygen.toCharArray().map { if (it == '0') 0 else 1 }.toIntArray().reversedArray()) * convert(co2.toCharArray().map { if (it == '0') 0 else 1 }.toIntArray().reversedArray()))
}

fun getMostFrequentBit(rows: List<String>, columnIdx: Int): Int {

    val ones = rows.count { it.get(columnIdx) == '1' }
    val zeros = rows.count { it.get(columnIdx) == '0' }

    val mostFrequent = if (ones >= zeros) 1 else 0
    return mostFrequent
}

fun getLessFrequentBit(rows: List<String>, columnIdx: Int): Int {

    val ones = rows.count { it.get(columnIdx) == '1' }
    val zeros = rows.count { it.get(columnIdx) == '0' }

    val mostFrequent = if (ones < zeros) 1 else 0
    return mostFrequent
}

fun convert(bits: IntArray): Long {
    var value = 0L
    for (i in 0 until bits.count()) {
        value += if (bits[i] == 1) 1L shl i else 0L
    }
    return value
}
