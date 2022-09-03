class fruit_basket {
  fun totalFruit(s: IntArray): Int {
		val basket = HashMap<Int, Int>()
		var max_length = 0
		var start = 0
		for (i in s.indices) {
			basket[s[i]] = basket.getOrPut(s[i]){0} + 1
			if (basket.size > 2) {
				basket.remove(s[start])
				start = i-1
			}
			max_length = max_length.coerceAtLeast(i - start + 1)
		}
		return max_length
  }
}

fun main() {
	val s = fruit_basket()
	println(s.totalFruit(intArrayOf(3,3,3,1,2,1,1,2,3,3,4)))
}