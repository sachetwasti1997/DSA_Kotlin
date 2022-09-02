package sliding_window

class Longest_Substring_Least_K_Repeat {
  fun longestSubstring(s: String, k: Int): Int {
    fun find(start: Int, end: Int): Int {
      if (start >= end) return 0
      val mp = HashMap<Char, Int>(26)
      for (i in start until end) mp[s[i]] = mp.getOrPut(s[i]){0}+1
      var left = 0
      var right = 0
      for (i in start until end) {
        mp[s[i]]?.let{
          if (it < k) {
            left = find(start, i)
            right = find(i+1, end)
            return left.coerceAtLeast(right)
          }
        }
      }
      return end - start
    }
    return find(0, s.length)
  }
}