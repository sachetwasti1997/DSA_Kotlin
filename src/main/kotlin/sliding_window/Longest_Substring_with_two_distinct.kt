package sliding_window

class Longest_Substring_with_two_distinct {
  fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    val map = HashMap<Char, Int>(s.length)
    var max_length = 0
    var start = 0
    for (i in s.indices) {
      map[s[i]] = map.getOrPut(s[i]){0}+1
      if (map.size > 2) {
        map[s[start]]?.let{ map[s[start]] = it - 1 }
        if (map[s[start]] == 0) map.remove(s[start])
        start++
      }
      max_length = max_length.coerceAtLeast(i - start + 1)
    }
    return max_length
  }
}

fun main() {
  val l = Longest_Substring_with_two_distinct()
  println(l.lengthOfLongestSubstringTwoDistinct("eceba"))
}