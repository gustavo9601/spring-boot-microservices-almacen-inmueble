package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);

        // Usuarios en memoria

        auth.inMemoryAuthentication()
                .withUser("gustavo")
                .password(new BCryptPasswordEncoder().encode("123"))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser("adolfo")
                .password(new BCryptPasswordEncoder().encode("123"))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        // Devolviendo las reglas de validacion sobre el api
        return http
                .antMatcher("/**").authorizeRequests().anyRequest().hasRole("ADMIN") // Require ADMIN role for all requests
                .and()
                .csrf().disable() // Desactivando el CSRF
                .httpBasic() // Habilita el Basic Auth
                .and()
                .build();
    }
}
