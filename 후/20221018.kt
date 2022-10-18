import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.parseInt
import java.util.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    var tokenizer = StringTokenizer(reader.readLine())

    val N = parseInt(tokenizer.nextToken()) // 표의 크기
    val M = parseInt(tokenizer.nextToken()) // 합을 구해야 하는 횟수

    // init arr
    val arr = Array(N) { Array(N) { 0 } }
    val sumArr = Array(N) { Array(N) { 0 } }
    for (row in 0 until N) {
        var sum = 0
        tokenizer = StringTokenizer(reader.readLine())
        for (col in 0 until N) {
            arr[row][col] = parseInt(tokenizer.nextToken())
            sum += arr[row][col]
        }
    }

    for (i in 1..M) {
        tokenizer = StringTokenizer(reader.readLine())
        val x1 = parseInt(tokenizer.nextToken()) - 1
        val y1 = parseInt(tokenizer.nextToken()) - 1
        val x2 = parseInt(tokenizer.nextToken()) - 1
        val y2 = parseInt(tokenizer.nextToken()) - 1
        var sum = 0
        for (row in x1..x2) {
            for (col in y1..y2) {
                sum += arr[row][col]
            }
        }
        writer.append(sum.toString())
        writer.append(System.lineSeparator())
    }

    writer.close()
    reader.close()
}
