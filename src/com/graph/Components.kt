package com.graph

class Components(graph: Graph) {

    private val G: Graph = graph

    private val visited: BooleanArray = BooleanArray(G.V())

    private var ccount = 0

    private var id: IntArray = IntArray(G.V())

    init {
        for (i in 0 until G.V()) {
            visited[i] = false
            id[i] = -1
        }
        for (i in 0 until G.V()) {
            if (!visited[i]) {
                dfs(i)
                ccount++
            }
        }
    }

    //图的深度优先遍历
    fun dfs(v: Int) {
        visited[v] = true
        id[v] = ccount

        for (i in G.adj(v)!!) {
            if (!visited[i!!]) {
                dfs(i)
            }
        }
    }

    // 返回图的联通分量个数
    fun count(): Int {
        return ccount
    }
}