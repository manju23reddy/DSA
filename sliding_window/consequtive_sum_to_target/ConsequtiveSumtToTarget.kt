package sliding_window.consequtive_sum_to_target

fun consequtiveSumToTarget(nums: IntArray, targetSum: Int): Boolean {
    var i = 0
    var j = 0
    var sum = 0
    while (j < nums.size) {

        if (sum < targetSum) {
            sum += nums[j]
            j++
        } else if (sum > targetSum) {
            sum -= nums[i]
            i++
        } else {
            return true
        }
    }
    return false
}