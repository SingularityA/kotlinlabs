package kotlinlabs.lab2

import kotlin.math.sqrt

/**
 * task A - 8
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
class MinimumDividerSeeker {
    fun findDivider(number: Int): Int {
        if (number <= 1) return -1
        for (i in 2..sqrt(number.toDouble()).toInt())
            if (number % i == 0)
                return i
        return number
    }
}