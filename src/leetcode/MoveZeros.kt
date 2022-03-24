package leetcode

fun main() {
    MoveZeros().moveZeroes(intArrayOf(0,1,0,3,12))
    MoveZeros().moveZeroes(intArrayOf(0))
}

class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        var leftPointer = 0
        var rightPointer = nums.lastIndex

        while(leftPointer < rightPointer) {
            if(nums[leftPointer] == 0) {
                nums.moveAllLeft(leftPointer, rightPointer)
                nums[rightPointer] = 0
                rightPointer--
            } else {
                leftPointer++
            }
        }
    }
}

/**
 * leftPointer ~ rightPointer 사이의 모든 요소를 왼쪽으로 한 칸씩 이동시킨다.
 */
private fun IntArray.moveAllLeft(
    leftPointer: Int,
    rightPointer: Int
): IntArray {
    var temp: Int = this[rightPointer]
    for(i in rightPointer-1 downTo leftPointer) {
        val currentElement = this[i]
        this[i] = temp
        temp = currentElement
    }
    return this
}