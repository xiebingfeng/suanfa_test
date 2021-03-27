package com.test.reverseList

class ReverseList {
}

fun main(args: Array<String>) {
    var head = Node(0, null)
    var lastNode: Node? = null
    for (i in 1..13) {
        val temp = Node(i, null)
        if (head.next == null) {
            head.next = temp
            lastNode = temp
        } else {
            lastNode?.next = temp
            lastNode = temp
        }
    }

    bianli(head)
    println()
    val result = reverseList(head)

    bianli(result)
}

fun reverseList(node: Node?): Node? {
    if (node?.next == null)
        return node

    val lastNode = reverseList(node.next)

    //当前节点的下个节点执行当前节点
    node.next?.next = node
    //把当前节点的原先节点断掉（也就是换向）
    node.next = null

    return lastNode
}

fun bianli(head: Node?) {
    if (head != null) {
        print(head.data.toString() + "  ")
        bianli(head.next)
    }

}