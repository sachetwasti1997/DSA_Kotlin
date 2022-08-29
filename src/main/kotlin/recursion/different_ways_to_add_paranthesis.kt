package recursion

class different_ways_to_add_paranthesis {
    fun diffWaysToCompute(e: String): List<Int> {
        val res = ArrayList<Int>()
        for (i in e.indices) {
            if (e[i] == '+' || e[i] == '-' || e[i] == '*') {
                val l1 = diffWaysToCompute(e.slice(0 until i))
                val l2 = diffWaysToCompute(e.slice(i+1 until e.length))
                for (x in l1) {
                    for (y in l2) {
                        if (e[i] == '+') res.add(x+y)
                        else if (e[i] == '-') res.add(x-y)
                        else if (e[i] == '*') res.add(x*y)
                    }
                }
            }
        }
        if (res.size == 0) res.add(e.toInt())
        return res
    }
}

fun main () {
    val e = "2*3-4*5"
    val d = different_ways_to_add_paranthesis()
    print(d.diffWaysToCompute(e))
}