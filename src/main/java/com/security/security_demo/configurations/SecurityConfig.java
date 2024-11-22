package com.security.security_demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetails() {
        UserDetails user = User.withUsername("User")
                .password("{noop}User")
//                .roles("USER")
                .authorities("USER")
                .build();

        UserDetails admin = User.withUsername("Admin")
                .password("{noop}Admin")
//                .roles("USER", "ADMIN")
                .authorities("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/*/public").permitAll()
//                        .requestMatchers("/user/**").hasRole("USER")
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/***").hasAuthority("USER")
                        .requestMatchers("/admin/***").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
//                .securityContext(securityContext -> securityContext.requireExplicitSave(false))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
