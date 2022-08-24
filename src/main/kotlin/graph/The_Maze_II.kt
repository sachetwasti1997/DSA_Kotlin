package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class The_Maze_II {
    fun shortestDistance(mz: Array<IntArray>, s: IntArray, d: IntArray): Int {
        val arr = PriorityQueue<ali>{a,b->a[2]-b[2]}
        val m = mz.size; val n = mz[0].size
        val dist = Array(m){IntArray(n){Int.MAX_VALUE}}
        val dir = arrayOf(1 to 0,0 to 1,-1 to 0, 0 to -1)
        dist[s[0]][s[1]] = 0
        val q = LinkedList<ali>()
        q.add(arrayListOf(s[0], s[1], 0))
        while (!q.isEmpty()) {
            val tmp = q.poll()
            if (dist[tmp[0]][tmp[1]] < tmp[2]) continue
            for (i in dir) {
                var x = tmp[0] + i.first
                var y = tmp[1] + i.second
                var cnt = 0
                while (x >= 0 && y >= 0 && x < m && y < n && mz[x][y] == 0) {
                    x += i.first
                    y += i.second
                    cnt++
                }
                x -= i.first; y -= i.second
                if (dist[tmp[0]][tmp[1]] + cnt < dist[x][y]) {
                    dist[x][y] = dist[tmp[0]][tmp[1]] + cnt
                    q.add(arrayListOf(x,y,dist[x][y]))
                }
            }
        }
        return if(dist[d[0]][d[1]] == Int.MAX_VALUE) -1 else dist[d[0]][d[1]]
    }
}
fun main() {
    val mz = arrayOf(intArrayOf(0,0,0,0,1,0,0),intArrayOf(0,0,1,0,0,0,0),intArrayOf(0,0,0,0,0,0,0),intArrayOf(0,0,0,0,0,0,1),intArrayOf(0,1,0,0,0,0,0),intArrayOf(0,0,0,1,0,0,0),intArrayOf(0,0,0,0,0,0,0),intArrayOf(0,0,1,0,0,0,1),intArrayOf(0,0,0,0,1,0,0))
    val s = intArrayOf(0, 0)
    val d = intArrayOf(8, 6)
    val mlst: List<Int> = ArrayList()
    val st: Set<Int> = HashSet()
    val m = The_Maze_II()
    m.shortestDistance(mz, s, d)
}