package se.ifmo.ru.Lab4.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import se.ifmo.ru.Lab4.entities.User
import se.ifmo.ru.Lab4.repositories.UserRepository

@RestController
class LoginController {
    @Autowired
    lateinit var userRepository: UserRepository
    @GetMapping("/login")
    fun login(@RequestParam(value = "name") name: String,
              @RequestParam(value = "password") password: String): Boolean {
        val passwordEncoder = BCryptPasswordEncoder()
        var hashpassword = passwordEncoder.encode(password)

        if (!usernameExists(name)){
            var newuser= User(name,hashpassword)
            userRepository.save(newuser)

            return true
        }
        else {

            var  existingpassword :String = userRepository.findPass(name)
            System.out.println(existingpassword)
            System.out.println(userRepository.findPass(name))
            return existingpassword.equals(password)
    }
    }
    private fun usernameExists(username: String): Boolean {
        return userRepository.findByUsername(username).isPresent
    }

}