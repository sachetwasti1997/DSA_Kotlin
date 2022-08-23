package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

typealias AI = ArrayList<Int>
typealias HmII = HashMap<Int, Int>
class SeqRec {
    fun sequenceReconstruction(nums: IntArray, s: List<List<Int>>): Boolean {
        val gr = HmIA()
        val n = nums.size
        val ind = HmII()
        for (i in 1 .. n) gr[i] = AI()
        for (i in 1 .. n) ind[i] = 0
        for (i in s) {
            for (j in 1 until i.size) {
                gr[i[j-1]]?.add(i[j])
                ind[i[j]]?.let{ind[i[j]] = it+1}
            }
        }
        val q = LinkedList<Int>()
        for (i in ind) {
            if (i.value == 0) q.add(i.key)
        }
        if (q.size > 1) return false
        while (!q.isEmpty()) {
            if (q.size > 1) return false
            val t = q.poll()
            for (i in gr[t].orEmpty()) {
                ind[i]?.let{ind[i] = it - 1}
                if (ind[i] == 0) q.add(i)
            }
        }
        return true
    }
}

fun main() {
    val s = SeqRec()
    val t = s.sequenceReconstruction(intArrayOf(1,2,3), listOf(listOf(1,2),listOf(1,3),listOf(2,3)))
    println(t)
    val t1 = IntArray(12)
    val h = mutableSetOf(arrayListOf(1,2))
    h.add(arrayListOf(1,2))
    println(h.size)
}