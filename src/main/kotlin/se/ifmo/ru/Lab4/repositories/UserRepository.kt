package se.ifmo.ru.Lab4.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import se.ifmo.ru.Lab4.entities.User
import java.util.*

interface UserRepository: CrudRepository<User, Long> {


    fun findByUsername(@Param("username") username: String): Optional<User>

    @Query(value = "select u.password from User u where u.username=?1")
    fun findPass(name:String):String
    @Query()
    fun setallinactive()
}