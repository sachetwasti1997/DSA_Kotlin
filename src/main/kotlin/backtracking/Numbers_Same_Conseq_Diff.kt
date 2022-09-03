package backtracking

import java.util.LinkedList

class Numbers_Same_Conseq_Diff {
  fun numsSameConsecDiff(n: Int, k: Int): IntArray {
    if (n == 1) return intArrayOf(1,2,3,4,5,6,7,8,9)
    val q = LinkedList<Int>()
    for (i in 1 .. 9) q.add(i)
    var cnt = 1
    var sz = 9
    while (!q.isEmpty()) {
      cnt ++
      for (i in 0 until sz) {
        val tmp = q.poll()
        val lst_dgt = tmp % 10
        if (lst_dgt + k < 10) q.add(10 * tmp + lst_dgt + k)
        if (lst_dgt - k >= 0) q.add(10 * tmp + lst_dgt - k)
      }
      if (cnt == n) break
      sz = q.size
    }
    val res =  IntArray(q.size)
    var i = 0
    while (!q.isEmpty()) res[i++] = q.poll()
    return res
  }
}

fun main() {
  val N = Numbers_Same_Conseq_Diff()
  N.numsSameConsecDiff(3, 7)
}