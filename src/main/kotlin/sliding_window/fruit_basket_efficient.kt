class fruit_basket {
	fun totalFruit(s: IntArray): Int {
		val basket = HashMap<Int, Int>(s.size)
    val endInx = HashMap<Int, Int>(s.size)
		var max_length = 0
		var start = 0
    var i = 0
		while (i < s.size) {
			if (endInx.size <= 2) endInx[s[i]] = i++
			if (endInx.size > 2) {
        var minInx = s.size - 1
        for ((it, v) in endInx)minInx = minInx.coerceAtMost(v)
        start = minInx+1
        endInx.remove(s[minInx])
			}
			max_length = max_length.coerceAtLeast(i - start)
		}
		return max_length
  }
}

fun main() {
	val s = fruit_basket()
	println(s.totalFruit(intArrayOf(3,3,3,1,2,1,1,2,3,3,4)))
}