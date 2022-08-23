package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class validate_bt {
    fun validateBinaryTreeNodes(n: Int, lft: ia, rht: ia): Boolean {
        var rt = 0
        val chNd = (lft+rht).toSet()
        for (i in 0 until n)
            if (!chNd.contains(i)) rt = i
        val q = LinkedList<Int>()
        q.add(rt)
        val vs = HashSet<Int>()
        while (!q.isEmpty()) {
            val node = q.poll()
            if (vs.contains(node)) return false
            vs.add(node)
            if (lft[node] != -1) q.add(lft[node])
            if (rht[node] != -1) q.add(rht[node])
        }
        return vs.size == n
    }
}

fun main() {
    val cns = arrayOf(intArrayOf(0,1), intArrayOf(1,3), intArrayOf(2,3))
    val gr = HashMap<Int, ArrayList<Int>>(2*cns.size).apply {
        cns.forEach {
            this[it[0]]?.add(it[1])
            this[it[1]]?.add(it[0])
        }
    }
    println(gr)
    for (i in gr) {
        println(i)
    }
}