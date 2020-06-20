package ru.havlong.cards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
@EnableJpaRepositories("ru.havlong.cards.repositories")
@EntityScan("ru.havlong.cards.models")
class CardsApplication {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}

fun main(args: Array<String>) {
    runApplication<CardsApplication>(*args)
}
