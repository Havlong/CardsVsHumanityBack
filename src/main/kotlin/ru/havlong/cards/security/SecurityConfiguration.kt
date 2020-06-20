package ru.havlong.cards.security

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * 13.06.2020
 * SecurityConfiguration
 *
 * @author Havlong
 * @version v1.0
 */
@Configuration
@ComponentScan("ru.havlong")
@EnableWebSecurity
class SecurityConfiguration(
        @Qualifier("userDetailsServiceImpl") private val userDetailsService: UserDetailsService,
        private val passwordEncoder: PasswordEncoder
) : WebSecurityConfigurerAdapter() {

//    override fun configure(auth: AuthenticationManagerBuilder?) {
//        if (auth == null) {
//            throw BackendException()
//        }
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
//    }

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable()
    }
}
