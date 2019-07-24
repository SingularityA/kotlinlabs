package kotlinlabs.lab1

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.slf4j.LoggerFactory
import java.util.*

/**
 * task B - 2
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
@RunWith(Parameterized::class)
class TriangleCheckerTest(private val triangle: IntArray, private val type: Int) {

    private val checker = TriangleChecker()
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(intArrayOf(3, 3, 3), 0),
            arrayOf(intArrayOf(3, 5, 4), 1),
            arrayOf(intArrayOf(10, 6, 5), 2),
            arrayOf(intArrayOf(10, 5, 5), -1)
        )
    }

    @Test
    fun testCheck() {
        val result = checker.check(*triangle)
        log.info("Data: ${Arrays.toString(triangle)} Expected: $type Result: $result")
        Assert.assertEquals(result, type)
    }
}