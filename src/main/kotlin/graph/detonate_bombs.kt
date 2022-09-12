package graph

import kotlin.math.pow
typealias hsil = HashMap<Int, ArrayList<Int>>
class detonate_bombs {
  fun maximumDetonation(bms: Array<IntArray>): Int {
    val gr = hsil(bms.size)
    for (i in bms.indices) {
      val x1 = bms[i][0]
      val y1 = bms[i][1]
      val d1 = bms[i][2]
      for (j in bms.indices ){
        if (i == j) continue
        val x2 = bms[j][0]
        val y2 = bms[j][1]
        val dis = Math.pow(((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)).toDouble(), 0.5)
        if(dis <= d1)
          gr.getOrPut(i){ ArrayList() }.add(j)
      }
    }
    var st = HashSet<Int>()
    var cnt = 0
    fun dfs(nd: Int) {
      st.add(nd)
      cnt++
      for (i in gr[nd].orEmpty()) {
        if (!st.contains(i)) dfs(i)
      }
    }
    var max_count = 0
    for (k in gr) {
      dfs(k.key)
      max_count = max_count.coerceAtLeast(st.size)
      st = HashSet()
    }
    return if (max_count != 0)max_count else 1
  }

}

fun main() {
  val d = detonate_bombs()
  d.maximumDetonation(arrayOf(intArrayOf(855,82,158),intArrayOf(17,719,430),intArrayOf(90,756,164),intArrayOf(376,17,340),intArrayOf(691,636,152),intArrayOf(565,776,5),intArrayOf(464,154,271),intArrayOf(53,361,162),intArrayOf(278,609,82),intArrayOf(202,927,219),intArrayOf(542,865,377),intArrayOf(330,402,270),intArrayOf(720,199,10),intArrayOf(986,697,443),intArrayOf(471,296,69),intArrayOf(393,81,404),intArrayOf(127,405,177)))
}