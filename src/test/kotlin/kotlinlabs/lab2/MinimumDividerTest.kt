package kotlinlabs.lab2

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.slf4j.LoggerFactory

/**
 * task A - 8
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
@RunWith(Parameterized::class)
class MinimumDividerTest(private val number: Int, private val divider: Int) {

    private val dividerSeeker = MinimumDividerSeeker()
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(2, 2),
            arrayOf(15, 3),
            arrayOf(23, 23),
            arrayOf(35, 5),
            arrayOf(106, 2),
            arrayOf(59, 59),
            arrayOf(-8, -1)
        )
    }

    @Test
    fun testFindDivider() {
        val result = dividerSeeker.findDivider(number)
        log.info("Data: $number Expected: $divider Result: $result")
        Assert.assertEquals(result, divider)
    }
}