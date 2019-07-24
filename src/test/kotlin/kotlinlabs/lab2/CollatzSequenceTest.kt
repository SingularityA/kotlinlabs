package kotlinlabs.lab2

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.slf4j.LoggerFactory

/**
 * test B - 8
 * Гипотеза Коллатца.
 * Рекуррентная последовательность чисел задана следующим образом:
 * ЕСЛИ (X четное), Xслед = X /2, ИНАЧЕ Xслед = 3 * X + 1.
 * Например, 15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
@RunWith(Parameterized::class)
class CollatzSequenceTest(private val startNumber: Int, private val steps: Int) {

    private val collatz = CollatzSequence()
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(3, 7),
            arrayOf(19, 20),
            arrayOf(15, 17)
        )
    }

    @Test
    fun test() {
        val result = collatz.countSteps(startNumber)
        log.info("Data: $startNumber Expected: $steps Result: $result")
        Assert.assertEquals(result, steps)
    }
}