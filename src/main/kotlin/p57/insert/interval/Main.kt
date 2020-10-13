package p57.insert.interval

class Solution {
    fun insert(intervals: Array<IntArray>, n: IntArray): Array<IntArray> {
        // maybe useless... remove this line feel free.
        if (intervals.isEmpty()) return arrayOf(n)

        val a = ArrayList<IntArray>(intervals.size)
        var m = false
        for (i in intervals) {
            if (i.first() in n || i.last() in n || n in i) {
                // any overlap
                if (!m) {
                    // unmerge, merge it
                    a.add(intArrayOf(minOf(i.first(), n.first()), maxOf(n.last(), i.last())))
                    m = true
                } else {
                    // contains, pass
                    if (i in n) continue
                    // otherwise merge it
                    a.last()[1] = i.last()
                }
            } else if (!m && i.first() > n.last()) {
                // no overlap
                m = true
                a.add(n)
                a.add(i)
            } else {
                a.add(i)
            }
        }
        if (!m) {
            // I'm angry.
            a.add(n)
        }
        return a.toTypedArray()
    }
}

inline fun IntArray.first() = this[0]
inline fun IntArray.last() = this[1]
inline operator fun IntArray.contains(i: Int) = this[0] <= i && this[1] >= i
inline operator fun IntArray.contains(i: IntArray) = i.first() in this && i.last() in this
