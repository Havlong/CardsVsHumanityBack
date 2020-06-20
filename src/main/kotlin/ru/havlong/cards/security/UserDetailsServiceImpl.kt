package ru.havlong.cards.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.havlong.cards.repositories.UsersRepository

/**
 * 13.06.2020
 * UserDetailsServiceImpl
 *
 * @author Havlong
 * @version v1.0
 */
@Service
class UserDetailsServiceImpl(private val usersRepository: UsersRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw UsernameNotFoundException("Provided with null username")
        }
        val user = usersRepository.findUserByUsername(username)
                ?: throw UsernameNotFoundException("User $username was not found in database")
        return UserDetailsImpl(user)
    }
}