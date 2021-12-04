import java.io.File

const val FILENAME = "src/main/kotlin/input.txt"

fun readInput(filename: String): List<String> = File(filename).useLines { it.toList() }

fun consolidateInstructions(data: List<String>): Pair<Int, Int> {
    var ascend: Int = 0
    var descend: Int = 0
    var forward: Int = 0

    data.forEach() {
        val cmds = it.split(" ")
        val cmd = cmds[0].trim()
        val value = cmds[1].toInt()
        when(cmd) {
            "up" -> ascend += value
            "down" -> descend += value
            "forward" -> forward += value
        }
    }
    val depth = descend - ascend
    return Pair(depth, forward)
}

fun calculateAim(data: List<String>): Int {
    var aim: Int = 0
    var depth: Int = 0
    var horizontal: Int = 0

    data.forEach() {
        val cmds = it.split(" ")
        val cmd = cmds[0].trim()
        val value = cmds[1].toInt()

        when(cmd) {
            "up" -> aim -= value
            "down" -> aim += value
            "forward" -> { horizontal += value; depth += ( value * aim )  }
        }
    }
    return depth * horizontal
}

fun main() {
    val data = readInput(FILENAME)
    val submarine = Submarine()
    val (depth, forward) = consolidateInstructions(data)
    submarine.chartCourse(depth, forward)
    println("Solution Part 1: ${submarine.depth * submarine.horizontal}")
    println("Solution Part 2: ${calculateAim(data)}")
}