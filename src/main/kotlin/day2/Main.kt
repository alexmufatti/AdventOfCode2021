package day2

import java.io.File

fun main(args: Array<String>) {
    val fileName = "input.txt"
    var prevValue: Int? = null

    val lines = File(fileName).readLines().map { it.toInt() }

    val increses = lines.mapIndexed { index, it ->
        if (lines.count() > index + 2) it + lines[index + 1] + lines[index + 2] else null
    }.filterNotNull().fold(0) { a, v ->
        val p = prevValue ?: Int.MAX_VALUE
        prevValue = v

        val ret = if (v > p) a + 1 else a
        println("""prev $p current $v increses $ret""")
        ret
    }

    println(increses)
}
