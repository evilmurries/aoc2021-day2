import java.io.File

const val FILENAME = "src/main/kotlin/input.txt"

fun readInput(filename: String): List<String> = File(filename).useLines { it.toList() }

fun countIncrements(data: List<String>): Int {
    var previousValue = data[0].toInt()
    var counter = 0

    data.forEach {
        if (it.toInt() > previousValue) {
            counter++
        }
        previousValue = it.toInt()
    }
    return counter
}

fun partTwo(data: List<String>): Int {
    val length = data.size
    var counter = 0
    var prevSum = data[0].toInt() + data[1].toInt() + data[2].toInt()

    for (i in 1 .. length - 1) {
        if ((i + 2) < length) {
            val currentSum = data[i].toInt() + data[i + 1].toInt() + data[i + 2].toInt()
            if (currentSum > prevSum) {
                counter++
            }
            prevSum = currentSum
        }
    }

    return counter
}

fun main() {
    val data = readInput(FILENAME)
    val solution1 = countIncrements(data)
    val solution2 = partTwo(data)
    println(solution1)
    println(solution2)
}