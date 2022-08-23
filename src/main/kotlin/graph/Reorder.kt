package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Reorder {
    fun minReorder(n: Int, cns: Array<IntArray>): Int {
        val dir = HashSet<Pair<Int, Int>>(cns.size)
        for (i in cns) dir.add(i[0] to i[1])
        val gr = Array(n) { ArrayList<Int>() }.apply {
            cns.forEach {
                this[it[0]].add(it[1])
                this[it[1]].add(it[0])
            }
        }
        val visit = HashSet<Int>(n)
        val q = LinkedList<Int>()
        var res = 0
        q.add(0)
        visit.add(0)
        while (!q.isEmpty()) {
            val tmp = q.poll()
            for (i in gr[tmp]) {
                if (!visit.contains(i)) {
                    if (!dir.contains(i to tmp)) res++
                    q.add(i)
                    visit.add(i)
                }
            }
        }
        return res
    }
}

fun main () {
    val r = Reorder()
    r.minReorder(6, arrayOf(intArrayOf(0,1),intArrayOf(1,3),intArrayOf(2,3),intArrayOf(4,0),intArrayOf(4,5)))
}