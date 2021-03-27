package com.graph

import java.util.Vector

// 稠密图 - 邻接矩阵
class DenseGraph(n: Int, directed: Boolean) : Graph {

    private val n: Int// 节点数

    private var m: Int// 边数

    private val directed: Boolean// 是否为有向图

    private val g: Array<BooleanArray>// 图的具体数据

    override fun V() = n// 返回节点个数

    override fun E() = m// 返回边的个数

    // 向图中添加一个边
    override fun addEdge(v: Int, w: Int) {
        assert(v in 0 until n)
        assert(w in 0 until n)
        if (hasEdge(v, w)) return
        g[v][w] = true
        if (!directed) g[w][v] = true
        m++
    }

    // 验证图中是否有从v到w的边
    override fun hasEdge(v: Int, w: Int): Boolean {
        assert(v in 0 until n)
        assert(w in 0 until n)
        return g[v][w]
    }

    // 显示图的信息
    override fun show() {
        for (i in 0 until n) {
            for (j in 0 until n) print(g[i][j].toString() + "\t")
            println()
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    override fun adj(v: Int): Iterable<Int> {
        assert(v in 0 until n)
        val adjV = Vector<Int>()
        for (i in 0 until n) if (g[v][i]) adjV.add(i)
        return adjV
    }

    // 构造函数
    init {
        assert(n >= 0)
        this.n = n
        m = 0 // 初始化没有任何边
        this.directed = directed
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = Array(n) { BooleanArray(n) }
    }
}