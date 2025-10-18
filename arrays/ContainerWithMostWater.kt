package arrays

fun ContainerWithMostWater(lengths: IntArray) : Int {
    var left = 0
    var right = lengths.size - 1
    var maxArea = 0
    while(left < right) {
        val height = Math.min(lengths[left], lengths[right])
        val width = right - left
        maxArea = Math.max(maxArea, height * width)

        if (lengths[left] < lengths[right]) {
            left++
        } else {
            right--
        }

    }
    return maxArea
}