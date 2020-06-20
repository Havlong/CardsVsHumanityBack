package ru.havlong.cards.models

import javax.persistence.*

/**
 * 13.06.2020
 * User
 *
 * @author Havlong
 * @version v1.0
 */
@Entity
@Table(name = "user")
data class User(
        @Id var id: Long?,
        @Enumerated(value = EnumType.STRING) var userState: UserState,
        @Enumerated(value = EnumType.STRING) var userRole: UserRole,
        var username: String,
        var hashPassword: String
) {
    constructor() : this(null, UserState.ACTIVE, UserRole.USER, "", "")
}
