class Submarine(var depth: Int = 0, var horizontal: Int = 0) {

    fun diveDeeper(amount: Int) {
        this.depth += amount
    }

    fun raiseDepth(amount: Int) {
        this.depth -= amount
    }

    fun moveForward(amount: Int) {
        this.horizontal += amount
    }

    fun chartCourse(depth: Int, distance: Int) {
        diveDeeper(depth)
        moveForward(distance)
    }
}