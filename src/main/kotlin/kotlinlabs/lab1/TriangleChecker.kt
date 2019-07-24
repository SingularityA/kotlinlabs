package kotlinlabs.lab1

/**
 * task B - 2
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
class TriangleChecker {
    fun check(vararg sides: Int): Int {
        if (sides.size != 3)
            throw IllegalArgumentException("Array must have 3 values!")

        if (!((sides[0] + sides[1] > sides[2])
                    and (sides[0] + sides[2] > sides[1])
                    and (sides[1] + sides[2] > sides[0]))
        )
            return -1

        sides.sort()

        val left = sides[2] * sides[2]
        val right = sides[0] * sides[0] + sides[1] * sides[1]

        return when {
            left < right -> 0
            left == right -> 1
            else -> 2
        }
    }
}