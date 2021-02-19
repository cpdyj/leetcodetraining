package p71.simplify.path

class Solution {
    fun simplifyPath(path: String): String {
        val a = ArrayDeque<String>()
        path.split('/').forEach {
            when (it) {
                "", "." -> {
                }
                ".." -> if (a.isNotEmpty()) a.removeLastOrNull()
                else -> a.addLast(it)
            }
        }
        return a.joinToString(separator = "/", prefix = "/")
    }
}