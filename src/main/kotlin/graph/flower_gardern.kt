package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

typealias ALI = ArrayList<Int>
class flower_gardern {
    fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
        val res = IntArray(n) {i->-1}
        val gr = HashMap<Int, ArrayList<Int>>()
        paths.forEach{
            if (gr[it[0]-1] == null) gr[it[0]-1] = ArrayList()
            if (gr[it[1]-1] == null) gr[it[1]-1] = ArrayList()
            gr[it[0]-1]?.add(it[1]-1)
            gr[it[1]-1]?.add(it[0]-1)
        }
        val v = HashSet<Int>()
        fun plant(nd: Int, col: Int) {
            var tar = col+1
            if (tar > 4) tar = 1
            res[nd] = col
            v.add(nd)
            for (i in gr[nd].orEmpty()) {
                if (!v.contains(i)) plant(i, tar)
            }
        }
        for (i in res.indices) {
            if (res[i] == -1) plant(i, 1)
        }
        return res
    }
    fun gardenNoAdj_BFS(n: Int, pth: Array<IntArray>): IntArray {
        val res = IA(n){i -> -1}
        val gr = HashMap<Int, ALI>()
        for (i in 0 until n) gr[i] = ALI()
        pth.forEach{
            gr[it[0]-1]?.add(it[1]-1)
            gr[it[1]-1]?.add(it[0]-1)
        }
        val q = LinkedList<Int>()
        val vst = HashSet<Int>()
        fun bfs(nd: Int, col: Int) {
            q.add(nd)
            res[nd] = col
            vst.add(nd)
            while (!q.isEmpty()) {
                val tmp = q.poll()
                for (i in gr[tmp].orEmpty()) {
                    var tar = res[tmp]+1
                    if (tar > 4) tar = 1
                    if (!vst.contains(i)) {
                        res[i] = tar
                        q.add(i)
                        vst.add(i)
                    }
                }
            }
        }
        for (i in res.indices) {
            if (res[i] == -1) bfs(i, 1)
        }
        for (i in res.indices) {
            val colst = HashSet<Int>()
            val colors = mutableSetOf(1,2,3,4)
            for (ch in gr[i].orEmpty()) {
                colst.add(res[ch])
                colors.remove(res[ch])
            }
            if (colst.contains(res[i])) {
                for (l in colors) {
                    res[i] = l
                }
            }
        }
        return res
    }
}
fun main() {
    val n = 6
    val arr1 = intArrayOf(1,2)
    val arr2 = intArrayOf(2,1)
    val st = (arr1+arr2).toSet()
    println(st)
    val arr = arrayOf(intArrayOf(6,4), intArrayOf(6,1), intArrayOf(3,1), intArrayOf(4,5)
        , intArrayOf(2,1), intArrayOf(5,6), intArrayOf(5,2))
//    val f = flower_gardern()
//    f.gardenNoAdj_BFS(n, arr)
    val t = IntArray(21)
    println(t.contentToString())
}











