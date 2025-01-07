package com.ogoma.blog.config;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.security.AppSecurityAuditAware;
import com.ogoma.blog.security.PIIEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
@EnableJpaAuditing
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults());
        return security.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
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
