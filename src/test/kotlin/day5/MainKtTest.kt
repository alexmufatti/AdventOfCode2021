package day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun drawLine() {
        val scheda = Map(10)
        drawLine(listOf(Pair(0, 0), Pair(0, 9)), scheda)
        scheda.print()
        assertEquals(1, scheda.rows[0][0])
        assertEquals(1, scheda.rows[0][1])
        assertEquals(1, scheda.rows[0][2])
        assertEquals(1, scheda.rows[0][3])
        assertEquals(1, scheda.rows[0][4])
        assertEquals(1, scheda.rows[0][5])
        assertEquals(1, scheda.rows[0][6])
        assertEquals(1, scheda.rows[0][7])
        assertEquals(1, scheda.rows[0][8])
        assertEquals(1, scheda.rows[0][9])
    }

    @Test
    fun drawLine1() {
        val scheda = Map(10)
        drawLine(listOf(Pair(0, 0), Pair(9, 9)), scheda)
        scheda.print()
        assertEquals(1, scheda.rows[0][0])
        assertEquals(1, scheda.rows[1][1])
        assertEquals(1, scheda.rows[2][2])
        assertEquals(1, scheda.rows[3][3])
        assertEquals(1, scheda.rows[4][4])
        assertEquals(1, scheda.rows[5][5])
        assertEquals(1, scheda.rows[6][6])
        assertEquals(1, scheda.rows[7][7])
        assertEquals(1, scheda.rows[8][8])
        assertEquals(1, scheda.rows[9][9])
    }

    @Test
    fun drawLine2() {
        val scheda = Map(10)
        drawLine(listOf(Pair(1, 3), Pair(0, 4)), scheda)
        scheda.print()
        assertEquals(1, scheda.rows[1][3])
        assertEquals(1, scheda.rows[0][4])
    }
}
