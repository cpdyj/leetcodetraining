package p1032.stream.of.characters

import java.io.Console
import java.util.*

class Node {
    val child = arrayOfNulls<Node>(26)
    var accept = false
    var fail: Node? = null
}


class StreamChecker(words: Array<String>) {
    val root = Node()
    var cur: Node = root

    init {
        words.forEach { s ->
            insertWord(s, 0, root)
        }
        build()
    }


    fun build() {
        val q = LinkedList<Node>()
        q.addLast(root)
        while (q.isNotEmpty()) {
            val current = q.removeFirst()!!
            current.child.forEachIndexed { index, node ->
                if (node == null) return@forEachIndexed
                q.addLast(node)

                var ft = current.fail
                while (true) {
                    if (ft == null) {
                        node.fail = root
                        break
                    }
                    val n = ft.child[index]
                    if (n != null) {
                        node.fail = n
                        break
                    }
                    ft = ft.fail
                }
            }
        }
        root.fail = root
    }

    tailrec fun insertWord(word: String, pos: Int, node: Node) {
        val c = word[pos] - 'a'
        if (node.child[c] == null) {
            node.child[c] = Node()
        }
        if (pos == word.lastIndex) {
            node.child[c]!!.accept = true
            return
        }
        insertWord(word, pos + 1, node.child[c]!!)
    }

    fun query(letter: Char): Boolean {
        val c = letter - 'a'
        while (true) {
            val n = cur.child[c]
            if (n == null) {
                if (cur === root) break
                cur = cur.fail!!
            } else {
                cur = n
                break
            }
        }
        var p = cur
        while (p !== root) {
            if (p.accept) {
                return true
            } else {
                p = p.fail!!
            }
        }
        return false
    }

}

fun main() {
    val c = System.console()
    val p = c.readPassword()
    println(p)
    val streamChecker = StreamChecker(arrayOf("cd", "f", "kl")) // init the dictionary.
    streamChecker.query('a')          // return false
    streamChecker.query('b')          // return false
    streamChecker.query('c')          // return false
    streamChecker.query('d')          // return true, because 'cd' is in the wordlist
    streamChecker.query('e')          // return false
    streamChecker.query('f')          // return true, because 'f' is in the wordlist
    streamChecker.query('g')          // return false
    streamChecker.query('h')          // return false
    streamChecker.query('i')          // return false
    streamChecker.query('j')          // return false
    streamChecker.query('k')          // return false
    streamChecker.query('l')          // return true, because 'kl' is in the wordlist

}
