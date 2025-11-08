package com.ogoma.blog.security;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserID;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AppSecurityAuditAware implements AuditorAware<UserID> {
    @Override
    public Optional<UserID> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .filter(x-> x instanceof UserEntity)
                .map(Authentication::getPrincipal)
                .map(UserEntity.class::cast).map(UserEntity::getId);
    }
}
