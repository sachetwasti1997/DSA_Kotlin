class Solution {
  fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length) return emptyList()
    val m1 = HashMap<Char, Int>(p.length)
    val m2 = HashMap<Char, Int>(s.length)
    for (i in p.indices) {
      m1[p[i]] = m1.getOrPut(p[i]){0}+1
      m2[s[i]] = m2.getOrPut(s[i]){0}+1
    }
    var start = 0
    var i = 0
    var res = ArrayList<Int>()
    while (i <= s.length - p.length) {
      var flag = 0
      for ( (k, v) in m1 ) {
        if (v != m2[k]) {
          flag = -1
          break
        }
      }
      if (flag == 0) res.add(i)
      m2[s[i]]?.let{ 
        m2[s[i]] = it - 1
        if (it - 1 == 0) m2.remove(s[i])
      }
      if (i+p.length < s.length) m2[s[i+p.length]] = m2.getOrPut(s[i+p.length]){0} + 1 
      i++
    }
    return res
  }
}