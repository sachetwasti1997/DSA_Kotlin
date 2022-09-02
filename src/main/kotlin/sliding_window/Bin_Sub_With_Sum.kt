package sliding_window

class Bin_Sub_With_Sum {
  fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var left = 0
    var right = 0
    var currSum = 0
    var numSubArr = 0
    while (left < nums.size && right < nums.size) {
      currSum += nums[right]
      if (currSum < goal) {
        right ++
      }else if (currSum > goal) {
        currSum = 0
        left++
        right = left
      }else {
        numSubArr++
        right++
        if (right == nums.size) {
          left++
          right = left
          currSum = 0
        }
      }
    }
    return numSubArr
  }
}