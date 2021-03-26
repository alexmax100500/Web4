package se.ifmo.ru.Lab4.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import se.ifmo.ru.Lab4.entities.Point
import se.ifmo.ru.Lab4.repositories.PointRepository

@RestController
class RecievePointsController{

    @Autowired
    lateinit var pointRepository: PointRepository

    @GetMapping("/point")
    fun recievePoint(@RequestParam(value = "x", defaultValue = "0") x: Double,
                 @RequestParam(value = "y", defaultValue = "0.0") y: Double,
                 @RequestParam(value = "r", defaultValue = "1") r: Double
    ):Point{
        System.out.println("They sent a point!")
        val point=Point("me", x,y, r)
        pointRepository.save(point)
        return point
    }
}