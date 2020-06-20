package ru.havlong.cards.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import ru.havlong.cards.models.User
import ru.havlong.cards.models.UserState
import java.util.*

/**
 * 13.06.2020
 * UserDetailsImpl
 *
 * @author Havlong
 * @version v1.0
 */
class UserDetailsImpl(private val userEntity: User) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
            Collections.singletonList(SimpleGrantedAuthority(userEntity.userRole.name))

    override fun isEnabled(): Boolean =
            userEntity.userState == UserState.ACTIVE

    override fun getUsername(): String =
            userEntity.username

    override fun isCredentialsNonExpired(): Boolean =
            true

    override fun getPassword(): String =
            userEntity.hashPassword

    override fun isAccountNonExpired(): Boolean =
            userEntity.userState != UserState.DELETED

    override fun isAccountNonLocked(): Boolean =
            userEntity.userState != UserState.BANNED
}