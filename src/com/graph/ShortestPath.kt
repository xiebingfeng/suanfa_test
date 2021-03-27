package com.graph

import java.util.LinkedList
import java.util.Vector
import java.util.Stack


/**
 * 层次、广度优先遍历
 */
class ShortestPath(val G: Graph, val s: Int) {

    private val visited = BooleanArray(G.V()) // 记录dfs的过程中节点是否被访问

    private val from = IntArray(G.V()) // 记录路径, from[i]表示查找的路径上i的上一个节点

    private val ord = IntArray(G.V())  // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    init {
        for (i in 0 until G.V()) {
            visited[i] = false
            from[i] = -1
            ord[i] = -1
        }

        // 无向图最短路径算法, 从s开始广度优先遍历整张图
        val q = LinkedList<Int>()

        q.push(s)
        visited[s] = true
        ord[s] = 0

        while (!q.isEmpty()) {
            val v = q.pop()
            for (i in G.adj(v)) {
                if (!visited[i]) {
                    q.push(i)
                    visited[i] = true
                    from[i] = v
                    ord[i] = ord[v] + 1
                }
            }
        }
    }

    // 查询从s点到w点是否有路径
    fun hasPath(w: Int): Boolean {
        assert(w >= 0 && w < G.V())
        return visited[w]
    }

    // 打印出从s点到w点的路径
    fun showPath(w: Int) {
        assert(hasPath(w))
        val vec: Vector<Int> = path(w)
        for (i in vec.indices) {
            print(vec.elementAt(i))
            if (i == vec.size - 1) println() else print(" -> ")
        }
    }

    // 查询从s点到w点的路径, 存放在vec中
    fun path(w: Int): Vector<Int> {
        assert(hasPath(w))
        val s = Stack<Int>()
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        var p = w
        while (p != -1) {
            s.push(p)
            p = from[p]
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        val res = Vector<Int>()
        while (!s.empty()) res.add(s.pop())
        return res
    }
}

fun main(args: Array<String>) {

    val filename = "testG.txt"
    val g = SparseGraph(7, false)
    val readGraph = ReadGraph(g, filename)
    g.show()
    println()

    // 比较使用深度优先遍历和广度优先遍历获得路径的不同
    // 广度优先遍历获得的是无权图的最短路径

    // 比较使用深度优先遍历和广度优先遍历获得路径的不同
    // 广度优先遍历获得的是无权图的最短路径
    val dfs = Path(g, 0)
    print("DFS : ")
    dfs.showPath(6)

    val bfs = ShortestPath(g, 0)
    print("BFS : ")
    bfs.showPath(6)
}