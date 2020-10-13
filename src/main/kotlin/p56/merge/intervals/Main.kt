package p56.merge.intervals

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val a = ArrayList<IntArray>(intervals.size)
        intervals.sortBy { it[0] }
        for (i in intervals) {
            if (a.isEmpty()) {
                a.add(i)
                continue
            }
            val l = a.last()
            if (l overlap i) {
                l[0] = minOf(l.first(), i.first())
                l[1] = maxOf(l.last(), i.last())
            } else {
                a.add(i)
            }
        }
        return a.toTypedArray()
    }
}

private inline fun IntArray.first() = this[0]
private inline fun IntArray.last() = this[1]
private inline operator fun IntArray.contains(i: Int) = i >= this[0] && i <= this[1]
private inline infix fun IntArray.overlap(i: IntArray) =
    i.first() in this || i.last() in this || this.last() in i


