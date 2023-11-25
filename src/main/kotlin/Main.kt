import kotlin.math.pow
import kotlin.math.sqrt

data class Point(val x: Double, val y: Double)

class Triangle(val vertex1: Point, val vertex2: Point, val vertex3: Point) {
    fun circumcenter(): Point {
        // Вычисление координат центра описанной окружности
        val a = vertex2.x - vertex1.x
        val b = vertex2.y - vertex1.y
        val c = vertex3.x - vertex1.x
        val d = vertex3.y - vertex1.y
        val e = a * (vertex1.x + vertex2.x) + b * (vertex1.y + vertex2.y)
        val f = c * (vertex1.x + vertex3.x) + d * (vertex1.y + vertex3.y)
        val g = 2 * (a * (vertex3.y - vertex2.y) - b * (vertex3.x - vertex2.x))

        val centerX = (d * e - b * f) / g
        val centerY = (a * f - c * e) / g

        return Point(centerX, centerY)
    }

    fun circumradius(center: Point): Double {
        // Вычисление радиуса описанной окружности
        val radius = sqrt((center.x - vertex1.x).pow(2) + (center.y - vertex1.y).pow(2))
        return radius
    }
}

fun main() {
    // Пример использования
    val vertex1 = Point(0.0, 0.0)
    val vertex2 = Point(1.0, 0.0)
    val vertex3 = Point(0.0, 1.0)

    val triangle = Triangle(vertex1, vertex2, vertex3)
    val circumcenter = triangle.circumcenter()
    val circumradius = triangle.circumradius(circumcenter)

    println("Центр описанной окружности: (${circumcenter.x}, ${circumcenter.y})")
    println("Радиус описанной окружности: $circumradius")
}