package com.ogoma.blog.auth.services;

import com.ogoma.blog.auth.dto.ForgotPasswordRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationResponseDto;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserEntity_;
import com.ogoma.blog.iam.repositories.UserRepository;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        UserEntity probe = new UserEntity();
        probe.setUsername(username);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase(UserEntity_.USERNAME);
        Example<UserEntity> entityExample = Example.of(probe, exampleMatcher);
        var user = this.userRepository.findOne(entityExample).orElseThrow(() -> new UsernameNotFoundException("Invalid user credentials"));
        log.info("Roles assigned", user.getRoles().size());
        return user;
    }

    public UserRegistrationResponseDto registerUser(UserRegistrationRequestDto userRegistrationDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userRegistrationDto.getEmail());
        user.setLastName(userRegistrationDto.getLastName());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setUsername(userRegistrationDto.getUsername());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        user.setPassword(userRegistrationDto.getPassword());
        this.userRepository.save(user);
        return new UserRegistrationResponseDto(user);
    }

    public void sendPasswordResetMail(ForgotPasswordRequestDto forgotPasswordRequestDto) {

    }
}
