package graph

import java.util.*
import kotlin.collections.ArrayList

typealias alp = Pair<Int, Double>
class Path_With_max_prob {
    fun maxProbability(n: Int, eg: Array<IntArray>, sP: DoubleArray, s: Int, e: Int): Double {
        var i = 0
        val gr = Array(n){ArrayList<alp>()}.apply{
            eg.forEach {
                this[it[0]].add(it[1] to sP[i])
                this[it[1]].add(it[0] to sP[i])
                i++
            }
        }
        val q = PriorityQueue<Pair<Int,Double>>( compareByDescending{it.second} )
        val d = DoubleArray(n) {Double.MIN_VALUE}
        d[s] = 1.0
        q.add(s to 1.0)
        while (!q.isEmpty()) {
            val tmp = q.poll()
            if(d[tmp.first] > tmp.second) continue
            for (i in gr[tmp.first]) {
                if (d[i.first] < tmp.second*i.second) {
                    d[i.first] = tmp.second*i.second
                    q.add(i.first to d[i.first])
                }
            }
        }
        return if(d[e] == Double.MIN_VALUE) 0.0 else d[e]
    }
}

fun main() {
    val eg = arrayOf(intArrayOf(1,4),intArrayOf(2,4),intArrayOf(0,4),intArrayOf(0,3),intArrayOf(0,2),intArrayOf(2,3))
    val d = doubleArrayOf(0.37,0.17,0.93,0.23,0.39,0.04)
    val p = Path_With_max_prob()
    p.maxProbability(5, eg, d, 3, 4)
}