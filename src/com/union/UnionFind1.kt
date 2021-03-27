package com.union

class UnionFind1(n: Int) {
    var id: Array<Int?> = arrayOfNulls(n)
    var cout: Int = n

    init {
        for (i in 0 until n) {
            id[i] = i
        }
    }

    private fun find(p: Int): Int {
        return id[p]!!
    }

    private fun isConnected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun unionElements(p: Int, q: Int) {
        val pId = find(p)  //前面的
        val qId = find(q)  //后面的

        if (pId == qId) {
            return
        }

        for (i in 0 until cout) {
            if (id[i] == qId) {
                id[i] = pId
            }
        }
    }

    fun print() {
        id.forEach {
            print(it!!.toString() + "  ")
        }
    }

}

fun main(args: Array<String>) {
    val unionFind = UnionFind1(10)
//    unionFind.unionElements(1, 4)
//    unionFind.unionElements(3, 9)
//    unionFind.unionElements(3, 1)

    unionFind.print();
}