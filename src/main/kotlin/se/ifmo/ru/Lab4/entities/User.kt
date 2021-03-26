package se.ifmo.ru.Lab4.entities

import javax.persistence.*

@Entity
@Table(name = "usr")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var username: String? = null
    var password: String? = null

    constructor(name: String, password: String) {
        this.username = name
        this.password = password

    }
    public fun gethashpassword():String?{
        return this.password
    }
}
