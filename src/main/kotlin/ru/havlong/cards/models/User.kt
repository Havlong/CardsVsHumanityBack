package ru.havlong.cards.models

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

/**
 * 13.06.2020
 * User
 *
 * @author Havlong
 * @version v1.0
 */
@Entity
data class User(
        @Id var id: Long,
        @Enumerated(value = EnumType.STRING) var userState: UserState,
        @Enumerated(value = EnumType.STRING) var userRole: UserRole,
        var username: String,
        var hashPassword: String
) {
    constructor() : this(0, UserState.ACTIVE, UserRole.USER, "", "")
}