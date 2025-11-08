package com.ogoma.blog.auth.services;

import com.ogoma.blog.auth.dto.ForgotPasswordRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationResponseDto;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserEntity_;
import com.ogoma.blog.iam.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;


@Service
@Slf4j
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Specification<UserEntity> spec = Specification.where(null);
        spec= spec.and((root,query,criteriaBuilder)->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get(UserEntity_.USERNAME)), StringUtils.toLowerCase(username, Locale.getDefault())));
        var user = this.userRepository.findOne(spec).orElseThrow(() -> new UsernameNotFoundException("Invalid user credentials"));
        log.info("Roles assigned", user.getRoles().size());
        return user;
    }

    public UserRegistrationResponseDto registerUser(UserRegistrationRequestDto userRegistrationDto) {
        UserEntity user = UserEntity.createNew(
                userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getPhoneNumber()
        );
        this.userRepository.save(user);
        return new UserRegistrationResponseDto(user);
    }

    public void sendPasswordResetMail(ForgotPasswordRequestDto forgotPasswordRequestDto) {

    }
}
