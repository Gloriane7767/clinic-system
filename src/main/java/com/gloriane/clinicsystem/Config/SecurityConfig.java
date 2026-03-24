package com.gloriane.clinicsystem.Config;

import com.gloriane.clinicsystem.security.CustomUserDetailsService;
import com.gloriane.clinicsystem.security.RoleBasedSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired private CustomUserDetailsService userDetailsService;
    @Autowired private RoleBasedSuccessHandler  successHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {

        // Build the provider inline — avoids circular bean dependency
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(passwordEncoder);
        provider.setUserDetailsService((org.springframework.security.core.userdetails.UserDetailsService) userDetailsService);

        http
            .authenticationProvider(provider)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**",
                        "/search-doctors",
                        "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/dashboard", "/patients", "/doctors", "/appointments").hasRole("ADMIN")
                .requestMatchers("/doctors/*/appointments").hasAnyRole("ADMIN", "DOCTOR")
                .requestMatchers("/prescriptions/**").hasAnyRole("ADMIN", "DOCTOR")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("email")
                .successHandler(successHandler)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .permitAll()
            );

        return http.build();
    }
}
