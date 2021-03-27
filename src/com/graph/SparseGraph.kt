package com.graph

import java.util.Vector

// 稀疏图 - 邻接表
class SparseGraph(n: Int, directed: Boolean) : Graph {

    private val n: Int// 节点数

    private var m: Int // 边数

    private val directed: Boolean // 是否为有向图

    private val g: Array<Vector<Int>>// 图的具体数据

    override fun V() = n // 返回节点个数

    override fun E() = m// 返回边的个数

    // 向图中添加一个边
    override fun addEdge(v: Int, w: Int) {
        assert(v in 0 until n)
        assert(w in 0 until n)
        g[v].add(w)
        if (v != w && !directed)
            g[w].add(v)
        m++
    }

    // 验证图中是否有从v到w的边
    override fun hasEdge(v: Int, w: Int): Boolean {
        assert(v in 0 until n)
        assert(w in 0 until n)
        for (i in g[v].indices) if (g[v].elementAt(i) == w) return true
        return false
    }

    // 显示图的信息
    override fun show() {
        for (i in 0 until n) {
            print("vertex $i:\t")
            for (j in g[i].indices) print(g[i].elementAt(j).toString() + "\t")
            println()
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    override fun adj(v: Int): Iterable<Int> {
        assert(v in 0 until n)
        return g[v]
    }

    // 构造函数
    init {
        assert(n >= 0)
        this.n = n
        m = 0 // 初始化没有任何边
        this.directed = directed
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = Array(n) { Vector<Int>(n) }
        for (i in 0 until n)
            g[i] = Vector()
    }
}