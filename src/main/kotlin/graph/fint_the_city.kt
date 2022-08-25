package graph

import java.util.*
import kotlin.collections.ArrayList

class fint_the_city {
    fun findTheCity(n: Int, eg: Array<IntArray>, dTh: Int): Int {
        val gr = Array(n){ArrayList<Pair<Int, Int>>()}.apply{
            eg.forEach{
                this[it[0]].add(it[1] to it[2])
                this[it[1]].add(it[0] to it[2])
            }
        }
        val r = IntArray(n)
        for (i in 0 until n) {
            val res = IntArray(n){Int.MAX_VALUE}
            val q = PriorityQueue<Pair<Int,Int>>(){a,b -> b.second-a.second}
            q.add(i to 0)
            res[i] = 0
            while (!q.isEmpty()) {
                val t = q.poll()
                for (k in gr[t.first]) {
                    if (t.second+k.second < res[k.first]) {
                        res[k.first] = t.second+k.second
                        q.add(k.first to t.second+k.second)
                    }
                }
            }
            for (j in res.indices) {
                if (j != i && res[j] <= dTh) r[j]++
            }
        }
        var m = Int.MAX_VALUE
        var res = Int.MIN_VALUE
        for (i in r.indices) {
            if (m >= r[i]) {
                m = r[i]
                res = i
            }
        }
        return res
    }
}

fun main() {
    val eg = arrayOf(intArrayOf(0,1,3),intArrayOf(1,2,1),intArrayOf(1,3,4),intArrayOf(2,3,1))
    val f = fint_the_city()
    f.findTheCity(4, eg, 4)
}