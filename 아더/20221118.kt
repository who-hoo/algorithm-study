import java.io.BufferedReader
import java.io.InputStreamReader

var N: Int = 0
var M: Int = 0
var answer: Int = 0
var nums = Array<Int>(10, { 0 })

fun main() {
    input()
    solve()
    print()
}

private fun print() {
    println(answer / 2)
}

private fun solve() {
    nums.sort()

    for (i in 0 until N) {
        answer += lower_bound(nums, 0, N - 1, nums[i], M)
    }
}

private fun lower_bound(A: Array<Int>, L1: Int, R1: Int, X: Int, M: Int): Int {
    var L: Int = L1
    var R: Int = R1

    while (L <= R) {
        var mid: Int = (L + R) / 2;
        if (nums[mid] + X <= M) {
            if (nums[mid] + X == M) {
                return 1
            }
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return 0
}

fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()
    nums = Array<Int>(N, { 0 })
    val split = br.readLine().split(" ")
    for (i in 0 until N) {
        nums[i] = split[i].toInt()
    }
    M = br.readLine().toInt()
}
