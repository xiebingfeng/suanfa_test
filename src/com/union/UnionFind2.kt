package com.union

class UnionFind2(n: Int) {

    var parent: Array<Int?> = arrayOfNulls(n)
    var cout: Int = n

    init {
        for (i in 0 until n) {
            parent[i] = i
        }
    }

    private fun find(_p: Int): Int {
        var p = _p
        while (p != parent[p]) {
            p = parent[p]!!
        }
        return p;
    }

    private fun isConnected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun unionElements(p: Int, q: Int) {
        //父节点
        val pRoot = find(p)  //前面的
        val qRoot = find(q)  //后面的

        if (pRoot == qRoot) {
            return
        }

        parent[pRoot] = qRoot
    }

    fun print() {
        parent.forEach {
            print(it!!.toString() + "  ")
        }
    }

}

fun main(args: Array<String>) {
    val unionFind = UnionFind2(10)
    unionFind.unionElements(1, 4)
    unionFind.unionElements(3, 9)
    unionFind.unionElements(3, 1)

    unionFind.print();
}