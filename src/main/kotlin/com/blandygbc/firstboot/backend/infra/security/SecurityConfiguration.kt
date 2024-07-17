package com.blandygbc.firstboot.backend.infra.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User.builder()
            .username("user")
            .password("{bcrypt}$2a$10\$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
            .roles("USER")
            .build()
        val admin = User.builder()
            .username("admin")
            .password("{bcrypt}$2a$10\$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
            .roles("USER", "ADMIN")
            .build()
        return InMemoryUserDetailsManager(user, admin)
    }


    @Bean
    fun securityFilterChain(http: HttpSecurity) : SecurityFilterChain {
        http.invoke {
            authorizeRequests {
                authorize("/main/admin",hasRole("ADMIN"))
                authorize(anyRequest,authenticated)
            }
            formLogin {  }
            logout {}
        }
        return http.build()
    }
}