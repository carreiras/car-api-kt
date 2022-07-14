package com.ewecarreira.car.domains

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Driver(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String,
    val birthDate: LocalDate
)

@Entity
data class Passenger(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String
)

data class PathDriver(
    val name: String?,
    val birthDate: LocalDate?
)

data class PathPassenger(
    val name: String?
)