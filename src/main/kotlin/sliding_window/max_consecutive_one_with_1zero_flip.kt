package sliding_window

import kotlin.math.abs

class max_consecutive_one_with_1zero_flip {
  fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var zroCnt = 0
    abs(2-3)
    var start = 0
    var max_ln = 0
    for (i in nums.indices) {
      if (nums[i] == 0) zroCnt++
      while (zroCnt > 1) {
        if (nums[start] == 0) zroCnt--
        start++
      }
      max_ln = max_ln.coerceAtLeast(i - start + 1)
    }
    return max_ln
  }
}