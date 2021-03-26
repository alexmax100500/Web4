package se.ifmo.ru.Lab4.entities

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "points")
class Point : Serializable {

    @SequenceGenerator(name = "seqGen", sequenceName = "gen_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    private var id: Int = 0
    var owner: String? = null
    var x: Double = 0.toDouble()
    var y: Double = 0.toDouble()
    var r: Double = 0.toDouble()
    var isCoordsStatus: Boolean = false
    var bornDate: Date? = null

    constructor(owner: String, x: Double, y: Double, r: Double) {
        this.owner = owner
        this.x = x
        this.y = y
        this.r = r
        isCoordsStatus = checkCoordinates(x, y, r)
        bornDate = Date()
    }

    constructor() {}

    private fun checkCoordinates(x: Double, y: Double, r: Double): Boolean {
        return x <= 0 && y >= 0 && x >= -r && y <= r / 2 || x >= 0 && y >= 0 && y <= (x - r / 2) * -2 ||
                x >= 0 && y <= 0 && x * x + y * y <= Math.pow(r, 2.0)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is Point) return false
        val point = o as Point?
        return java.lang.Double.compare(point!!.x, x) == 0 &&
                java.lang.Double.compare(point.y, y) == 0 &&
                java.lang.Double.compare(point.r, r) == 0 &&
                isCoordsStatus == point.isCoordsStatus
    }

    override fun hashCode(): Int {
        return Objects.hash(id, owner, x, y, r, isCoordsStatus, bornDate)
    }

    override fun toString(): String {
        return "<tr><td>" + x + "</td>" +
                "<td>" + y + "</td>" +
                "<td>" + r + "</td>" +
                "<td style='color: " + (if (isCoordsStatus) "green" else "red") + "'>" + isCoordsStatus + "</td>" +
                "<td>" + bornDate + "</td></tr>"
    }

    fun getId(): Long {
        return id.toLong()
    }

    fun setId(id: Int) {
        this.id = id
    }

    companion object {

        @Transient
        private const val serialVersionUID = 4L
    }
}