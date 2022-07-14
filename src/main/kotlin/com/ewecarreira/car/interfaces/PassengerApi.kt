package com.ewecarreira.car.interfaces

import com.ewecarreira.car.domains.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class PassengerApi(val passengerRepository: PassengerRepository) {

    @GetMapping("/passengers")
    fun listPassengers() = passengerRepository.findAll()

    @GetMapping("/passengers/{id}")
    fun findPassenger(@PathVariable("id") id: Long) = passengerRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping("/passengers")
    fun createPassenger(@RequestBody passenger: Passenger): Passenger = passengerRepository.save(passenger)

    @PutMapping("/passengers/{id}")
    fun fullUpdatePassenger(@PathVariable("id") id: Long, @RequestBody passenger: Passenger): Passenger {
        val foundPassenger = findPassenger(id)
        val copyPassenger = foundPassenger.copy(
            name = passenger.name
        )
        return passengerRepository.save(copyPassenger)
    }

    @PatchMapping("/passengers/{id}")
    fun incrementalUpdatePassenger(@PathVariable("id") id: Long, @RequestBody passenger: PathPassenger): Passenger {
        val foundPassenger = findPassenger(id)
        val copyPassenger = foundPassenger.copy(
            name = passenger.name ?: foundPassenger.name
        )
        return passengerRepository.save(copyPassenger)
    }

    @DeleteMapping("/passengers/{id}")
    fun deletePassenger(@PathVariable("id") id: Long) = passengerRepository.delete(findPassenger(id))
}