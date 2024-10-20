package ru.my.kafka.producer.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.my.kafka.producer.kafka.JsonKafkaProducer

@RestController
class KafkaProducerController(
    private val kafkaProducer: JsonKafkaProducer
) {

    companion object {
        private const val BASE_URI = "/api/send"
        const val SEND_JSON = "${BASE_URI}/json"
    }

    @PostMapping(SEND_JSON)
    fun sendToProducer(@RequestBody jsonString: String): ResponseEntity<String> {
        kafkaProducer.send(jsonString)
        return ResponseEntity.ok().build()
    }
}