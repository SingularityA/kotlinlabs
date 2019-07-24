package kotlinlabs.lab1

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.slf4j.LoggerFactory

/**
 * task A - 8
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке(например, 874).
 */
@RunWith(Parameterized::class)
class NumberReverserTest(private val number: Int, private val mirror: Int) {

    private val reverser = NumberReverser()
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(0, 0),
            arrayOf(9, 9),
            arrayOf(84, 48),
            arrayOf(576, 675),
            arrayOf(9037, 7309),
            arrayOf(50, 5),
            arrayOf(650, 56),
            arrayOf(700, 7)
        )
    }

    @Test
    fun testReverse() {
        val result = reverser.mirror(number)
        log.info("Data: $number Expected: $mirror Result: $result")
        Assert.assertEquals(result, mirror)
    }
}