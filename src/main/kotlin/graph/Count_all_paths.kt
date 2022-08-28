package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.pow

class Count_all_paths {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val gr = Array(n) { ArrayList<ali>() }.apply {
            roads.forEach {
                this[it[0]].add(arrayListOf(it[1], it[2]))
                this[it[1]].add(arrayListOf(it[0], it[2]))
            }
        }
        val q = PriorityQueue<IntArray>(){a,b-> a[1]-b[1]}
        val dis = IntArray(n){Int.MAX_VALUE}
        val ways = IntArray(n){0}
        val MOD = 10.00.pow(9).toInt() + 7
        dis[0] = 0
        ways[0] = 1
        q.add(intArrayOf(0, 0))
        while (!q.isEmpty()) {
            val (curr, crr_dis) = q.poll()
            for ((ch, ch_dis) in gr[curr]) {
                if (dis[ch] > crr_dis+ch_dis) {
                    ways[ch] = ways[curr]
                    dis[ch] = crr_dis+ch_dis
                    q.add(intArrayOf(ch, dis[ch]))
                }else if (crr_dis+ch_dis == dis[ch]) ways[ch] = (ways[ch]+ways[curr]) % (MOD)
            }
        }
        return ways[n-1]
    }
}

fun main() {
    val c = Count_all_paths()
    c.countPaths(7, arrayOf(intArrayOf(0,6,7),intArrayOf(0,1,2),intArrayOf(1,2,3),intArrayOf(1,3,3),intArrayOf(6,3,3),intArrayOf(3,5,1),intArrayOf(6,5,1),intArrayOf(2,5,1),intArrayOf(0,4,5),intArrayOf(4,6,2)))
}