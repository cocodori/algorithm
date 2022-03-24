package leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val listNode: ListNode? = ListNode(1)
    val middleNode = MiddleOfTheLinkedList().middleNode(listNode)
    println(middleNode?.`val`)
}

class MiddleOfTheLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        val list = ListNodeWrapper(head)
        return list.breakLinkBeforeMiddle()
    }
}

class ListNodeWrapper(
    private val head: ListNode?
) {
    val size: Int
        get() {
            var size = 0
            var node: ListNode? = head
            while (node != null) {
                node = node.next
                size++
            }
            return size
        }

    operator fun get(index: Int): Int? {
        validCheck(index)
        val target: ListNode? = findTarget(index)
        return target?.`val`
    }

    fun breakLinkBeforeMiddle(): ListNode? {
        val middle = size/2-1
        val afterMiddle = if (size == 1) findTarget(middle)
        else findTarget(middle)?.next
        return afterMiddle
    }

    private fun findTarget(index: Int): ListNode? {
        var target: ListNode? = head
        for (i in 0 until index) {
            target = target?.next
        }
        return target
    }

    private fun validCheck(index: Int) {
        if (size <= index) throw IndexOutOfBoundsException()
    }
}