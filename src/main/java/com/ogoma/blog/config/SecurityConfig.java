package com.ogoma.blog.config;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.security.AppSecurityAuditAware;
import com.ogoma.blog.security.PIIEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return security.build();
    }

    @Bean
    public static PIIEncryptor piiEncryptor() {
        return new PIIEncryptor();
    }
    @Bean
    public AuditorAware<UserEntity> auditorProvider() {
        return new AppSecurityAuditAware();
    }
}
