package se.ifmo.ru.Lab4.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import se.ifmo.ru.Lab4.entities.Point
import se.ifmo.ru.Lab4.repositories.PointRepository

@RestController
class GetPointsController {
    @Autowired
    lateinit var pointRepository: PointRepository
    @GetMapping("/points")
    fun getPoints(): MutableIterable<Point> {


        return pointRepository.findAll()
    }
}