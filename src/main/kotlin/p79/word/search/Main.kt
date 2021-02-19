package p79.word.search

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val mx = board.size
        val my = board[0].size
        val f = IntArray(mx * my / 32 + 1)

        board.forEachIndexed { x, chars ->
            chars.forEachIndexed { y, c ->
                if (a(x, y, board, word, 0, mx, my, f)) {
                    return true
                }
            }
        }
        return false
    }

    fun a(x: Int, y: Int, board: Array<CharArray>, word: String, p: Int, mx: Int, my: Int, f: IntArray): Boolean {
//        println("$x, $y")
        if (p == word.length) return true
//        println(f[0])
        if (x in 0 until mx && y in 0 until my &&(f[(x * my + y) / 32] and (1 shl ((x * my + y) % 32))) == 0) {
//            if ((f[(x * my + y) / 32] and (1 shl ((x * my + y) % 32))) != 0) return false
            if (board[x][y] != word[p]) return false
//            println("$x, $y, ${word[p]} -> ${board[x][y]}")
            f[(x * my + y) / 32] = f[(x * my + y) / 32] xor (1 shl ((x * my + y) % 32))
            check((f[(x * my + y) / 32] and (1 shl ((x * my + y) % 32))) != 0)
            val r = a(x + 1, y, board, word, p + 1, mx, my, f)
                    || a(x - 1, y, board, word, p + 1, mx, my, f)
                    || a(x, y + 1, board, word, p + 1, mx, my, f)
                    || a(x, y - 1, board, word, p + 1, mx, my, f)
            f[(x * my + y) / 32] = f[(x * my + y) / 32] xor (1 shl ((x * my + y) % 32))
            check((f[(x * my + y) / 32] and (1 shl ((x * my + y) % 32))) == 0)
            return r
        }
        return false
    }

}

fun main() {
    val a = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val b = arrayOf(
        charArrayOf('a','b'),
        charArrayOf('c','d')
    )
    println(Solution().exist(a, "ABCB"))
    println(Solution().exist(b, "acdb"))
}
//[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
//"ABCB"