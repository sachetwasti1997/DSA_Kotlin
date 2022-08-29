package recursion

class fast_power {
    fun myPow(x: Double, n: Int): Double {
        var x1 = x
        var n1 = n.toLong()
        if (n1 < 0) {
            x1 = 1 / x1
            n1 *= -1
        }
        fun calc(n1: Long): Double {
            if (n1 == 0L) return 1.0
            val ans = calc(n1/2)
            if ((n1%2) != 0L) return x1 * ans * ans
            return ans * ans
        }
        if (n1 >= 0) return calc(n1)
        else return 1/calc(n1)
    }
}

fun main() {
    val fp = fast_power()
    var n = -2147483648
    var x = 2.0
    val res = fp.myPow(x, n)
    print(res)
}