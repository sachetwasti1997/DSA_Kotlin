package sliding_window

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    var curr = 1
    var cnt = 0
    while (left < nums.size && right < nums.size) {
      curr *= nums[right]
      if (curr >= k) {
        curr = 1
        left++
        right = left
      }else {
        cnt++
        right++
        if (right == nums.size) {
          left++
          curr = 1
          right = left
        }
      }
    }
    return cnt
  }