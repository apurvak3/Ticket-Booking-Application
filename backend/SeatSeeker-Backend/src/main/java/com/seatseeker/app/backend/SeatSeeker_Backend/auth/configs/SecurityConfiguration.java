package com.seatseeker.app.backend.SeatSeeker_Backend.auth.configs;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.services.AuthFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthFilterService authFilterService;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/superAdmin/**").hasRole("SUPERADMIN")
                        .requestMatchers("/auth/**", "/forgotPassword/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authFilterService, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}