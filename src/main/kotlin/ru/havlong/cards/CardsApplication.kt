package ru.havlong.cards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("ru.havlong.cards.repositories")
@EntityScan("ru.havlong.cards.models")
class CardsApplication

fun main(args: Array<String>) {
    runApplication<CardsApplication>(*args)
}
