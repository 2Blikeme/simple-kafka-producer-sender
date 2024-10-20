package ru.my.kafka.producer.kafka

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class JsonKafkaProducer(
    private val kafkaTemplate: KafkaTemplate<Int, String>
) {

    @Value("\${kafka.topic.name}")
    private var topicName = ""

    fun send(message: String) {
        kafkaTemplate.send(topicName, message)
    }

}