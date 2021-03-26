package se.ifmo.ru.Lab4.repositories

import org.springframework.data.repository.CrudRepository
import se.ifmo.ru.Lab4.entities.Point


interface PointRepository : CrudRepository<Point, Int>