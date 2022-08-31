package sliding_window

class Lngst_Subs_With_K_Char {
  fun longestSubstring(s: String, k: Int): Int {
    fun find (st: Int, e: Int): Int {
      if (st >= e) return 0
      val map = HashMap<Char, Int> ()
      var dvdIndx = -1
      var lr = -1
      for (i in st .. e) {
        map[s[i]] = map.getOrPut(s[i]){0} + 1
        map[s[i]]?.let { 
          if (it < k) dvdIndx = i
          else if (it > lr) lr = it 
        }
      }
      val mx = Math.max(find(st, dvdIndx-1), find(dvdIndx+1, e))
      return lr.coerceAtLeast(mx)
    }
    return find(0, s.length-1)
  }
}

fun main() {
  val L = Lngst_Subs_With_K_Char()
  println(L.longestSubstring("ababbc", 3))
}