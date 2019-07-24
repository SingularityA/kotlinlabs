package kotlinlabs.lab1

/**
 * task A - 8
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке(например, 874).
 */
class NumberReverser {
    fun mirror(number: Int, base: Int = 10): Int {
        if (number < 0) return mirror(-number)

        var digit: Int
        var result = 0
        var rest = number

        while (rest > 0) {
            digit = rest % base
            rest /= base
            result = result * base + digit
        }
        return result
    }
}