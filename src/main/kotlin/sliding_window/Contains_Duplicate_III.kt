package sliding_window

class Contains_Duplicate_III {
  fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    val arr = Array(nums.size){i->nums[i].toLong() to i}
    for (i in nums.indices) {
      var j = i + 1
      while (j < i+1+k && j < nums.size) {
        if (Math.abs(arr[j].first - arr[i].first) <= k) return true
        j++
      }
    }
    return false
  }
}

fun main() {
  /*
  [-2147483648,2147483647]
1
1
   */
  val nums = intArrayOf(-2147483648,2147483647)
  val c = Contains_Duplicate_III()
  println(c.containsNearbyAlmostDuplicate(nums, 1, 1))
}

