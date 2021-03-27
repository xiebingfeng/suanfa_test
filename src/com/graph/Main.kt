package com.graph

import kotlin.jvm.JvmStatic

// 测试图的联通分量算法
object Main {

    @JvmStatic
    fun main(args: Array<String>) {

//        // TestG1.txt
//        val filename1 = "testG1.txt"
//        val g1 = SparseGraph(13, false)
//        ReadGraph(g1, filename1)
//        val component1 = Components(g1)
//        println("TestG1.txt, Component Count: " + component1.count())
//        println()
//
//        // TestG2.txt
//        val filename2 = "testG2.txt"
//        val g2 = SparseGraph(6, false)
//        ReadGraph(g2, filename2)
//        val component2 = Components(g2)
//        println("TestG2.txt, Component Count: " + component2.count())

        val filename = "testG.txt"
        val g = SparseGraph(7, false)
        val readGraph = ReadGraph(g, filename)
        g.show()
        println()

        val path = Path(g, 0)
        println("Path from 0 to 6 : ")
        path.showPath(6)
    }
}