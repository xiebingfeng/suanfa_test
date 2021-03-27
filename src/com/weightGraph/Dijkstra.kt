package com.weightGraph

import com.sun.corba.se.impl.orbutil.graph.Graph
import java.util.Vector

import java.util.Stack


class Dijkstra<Weight>(val g: WeightedGraph<Weight>, val s: Int) where Weight : Number, Weight : Comparable<*> {

    private val distTo = Array<Number>(g.V()) { 0.0 }

    private val marked = Array<Boolean>(g.V()) { false }

    private val from = Array<Edge<Weight>?>(g.V()) {
        null
    }

    init {
        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        val ipq = IndexMinHeap<Weight>(g.V())

        // 对于起始点s进行初始化
        distTo[s] = 0.0
        from[s] = Edge(s, s, 0.0 as Weight)
        ipq.insert(s, distTo[s] as Weight)
        marked[s] = true

        while (!ipq.isEmpty) {
            val v = ipq.extractMinIndex()

            // distTo[v]就是s到v的最短距离
            marked[v] = true;

            // distTo[v]就是s到v的最短距离
            for (item in g.adj(v)) {
                val w = item.other(v)
                if (!marked[w]) {
                    // 如果w点以前没有访问过,
                    // 或者访问过, 但是通过当前的v点到w点距离更短, 则进行更新
                    if (from[w] == null || distTo[v].toDouble() + item.wt().toDouble() < distTo[w].toDouble()) {
                        distTo[w] = distTo[v].toDouble() + item.wt().toDouble()
                        from[w] = item
                        if (ipq.contain(w)) {
                            ipq.change(w, distTo[w] as Weight)
                        } else {
                            ipq.insert(w, distTo[w] as Weight)
                        }
                    }
                }
            }
        }
    }

    // 返回从s点到w点的最短路径长度
    fun shortestPathTo(w: Int): Number? {
        assert(w >= 0 && w < g.V())
        assert(hasPathTo(w))
        return distTo[w]
    }

    // 判断从s点到w点是否联通
    fun hasPathTo(w: Int): Boolean {
        assert(w >= 0 && w < g.V())
        return marked[w]
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    fun shortestPath(w: Int): Vector<Edge<Weight>> {
        assert(w >= 0 && w < g.V())
        assert(hasPathTo(w))

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        val s = Stack<Edge<Weight>>()
        var e = from[w]!!
        while (e.v() != this.s) {
            s.push(e)
            e = from[e.v()]!!
        }
        s.push(e)

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        val res = Vector<Edge<Weight>>()
        while (!s.empty()) {
            e = s.pop()
            res.add(e)
        }
        return res
    }

    // 打印出从s点到w点的路径
    fun showPath(w: Int) {
        assert(w >= 0 && w < g.V())
        assert(hasPathTo(w))
        val path = shortestPath(w)
        for (i in path.indices) {
            print(path.elementAt(i).v().toString() + " -> ")
            if (i == path.size - 1) println(path.elementAt(i).w())
        }
    }
}

fun main(args: Array<String>) {
    val filename = "testDijkstraG1.txt"
    val V = 5

    val g = SparseWeightedGraph<Double>(V, true)
    // Dijkstra最短路径算法同样适用于有向图
    //SparseGraph<int> g = SparseGraph<int>(V, false);
    // Dijkstra最短路径算法同样适用于有向图
    //SparseGraph<int> g = SparseGraph<int>(V, false);
    val readGraph = ReadWeightedGraph(g, filename)

    println("Test Dijkstra:\n")
    val dij = Dijkstra(g, 0)
    for (i in 1 until V) {
        if (dij.hasPathTo(i)) {
            println("Shortest Path to " + i + " : " + dij.shortestPathTo(i))
            dij.showPath(i)
        } else println("No Path to $i")
        println("----------")
    }
}