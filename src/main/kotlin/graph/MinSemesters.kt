package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

typealias mii = HashMap<Int, Int>
typealias ali = ArrayList<Int>
typealias sti = HashSet<Int>
class MinSemesters {
    fun minimumSemesters(n: Int, rlns: Array<IntArray>): Int {
        val visit = sti(n)
        val indg = mii(n)
        for (i in 0 until n) indg[i] = 0
        val gr = Array(n){ali()}.apply{
            rlns.forEach{
                this[it[0] - 1].add(it[1] - 1)
                indg[it[1] - 1]?.let{dg -> indg[it[1] - 1] = dg+1 }
            }
        }
        val q = LinkedList<Int>()
        indg.forEach{
            if (it.value == 0) q.add(it.key)
        }
        var sz = q.size
        var res = 0
        while (!q.isEmpty()) {
            res++
            for (i in 0 until sz) {
                val tmp = q.poll()
                for (ch in gr[tmp]) {
                    indg[ch]?.let{ indg[ch] = it - 1 }
                    if (indg[ch] == 0) {
                        q.add(ch)
                    }
                }
            }
            sz = q.size
        }
        return res
    }
}

fun main() {
    val indg = mii()
    indg.forEach {
        println(it.key)
    }
}