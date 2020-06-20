package ru.havlong.cards.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.havlong.cards.models.User

/**
 * 13.06.2020
 * UsersRepository
 *
 * @author Havlong
 * @version v1.0
 */
interface UsersRepository : JpaRepository<User, Long> {
    fun findUserByUsername(username: String): User?
}