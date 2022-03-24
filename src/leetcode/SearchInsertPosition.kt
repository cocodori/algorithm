package leetcode

/**
 * 정렬된 정수 배열과 target이 주어지면 배열에서 target을 찾아서 반환해라.
 * 만약 target이 없다면, target이 정수 배열과 함께 순차적으로 삽입되었다면 어떤 위치에 있을지 그 위치를 반환해라.
 *
 * 반드시 시간 복잡도가 O(log n)이어야 한다.
 */
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1
        var pivot = calcPivot(left, right)

        while(left <= right) {
            if(nums[pivot] == target) {
                return pivot
            }
            else if(nums[pivot] > target) {
                right = pivot-1
                pivot = calcPivot(left, right)

            }
            else if(nums[pivot] < target) {
                left = pivot+1
                pivot = calcPivot(left, right)
            }
        }

        // 피벗이 타겟보다 크거나,
        // pivot이 out of index면 pivot 위치에 삽입하면 됨
        //그 외 타겟이 더 큰 경우 pivot + 1
        return if (pivot > nums.size-1)
            pivot
        else if(nums[pivot] > target)
            pivot
        else
            pivot+1
    }

    private fun calcPivot(left: Int, right: Int) = left + (right-left)/2
}

fun main() {
    val searchInsertPosition = SearchInsertPosition()
    val case1 = searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 5)
    val case2 = searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 2)
    val case3 = searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 7)

    println(case1)
    println(case2)
    println(case3)
}