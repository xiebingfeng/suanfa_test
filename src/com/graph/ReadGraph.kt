package com.graph

import java.io.FileInputStream
import java.io.BufferedInputStream
import java.io.File
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*

class ReadGraph(graph: Graph, filename: String?) {

    private var scanner: Scanner? = null

    private fun readFile(filename: String?) {
        assert(filename != null)
        try {
            val file = File(filename)
            if (file.exists()) {
                val fis = FileInputStream(file)
                scanner = Scanner(BufferedInputStream(fis), "UTF-8")
                scanner!!.useLocale(Locale.ENGLISH)
            } else throw IllegalArgumentException(filename + "doesn't exist.")
        } catch (ioe: IOException) {
            throw IllegalArgumentException("Could not open $filename", ioe)
        }
    }

    init {
        readFile(filename)
        try {
            val V = scanner!!.nextInt()
            if (V < 0) throw IllegalArgumentException("number of vertices in a Graph must be nonnegative")
            assert(V == graph.V())
            val E = scanner!!.nextInt()
            if (E < 0) throw IllegalArgumentException("number of edges in a Graph must be nonnegative")
            for (i in 0 until E) {
                val v = scanner!!.nextInt()
                val w = scanner!!.nextInt()
                assert(v in 0 until V)
                assert(w in 0 until V)
                graph.addEdge(v, w)
            }
        } catch (e: InputMismatchException) {
            val token = scanner!!.next()
            throw InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"$token\"")
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available")
        }
    }
}