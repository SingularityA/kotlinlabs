package kotlinlabs.lab2

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
class CollatzSequence {
    fun countSteps(startValue: Int): Int {
        if (startValue <= 0)
            return -1

        var value = startValue
        var steps = 0

        while (value != 1) {
            steps += 1

            value = if (value % 2 == 0)
                value / 2
            else
                3 * value + 1
        }
        return steps
    }
}