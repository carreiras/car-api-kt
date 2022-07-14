package com.ewecarreira.car

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarApiApplication

fun main(args: Array<String>) {
	runApplication<CarApiApplication>(*args)
}
