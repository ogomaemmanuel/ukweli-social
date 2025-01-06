package com.ogoma.blog.auth.services;

import com.ogoma.blog.auth.dto.ForgotPasswordRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationResponseDto;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserEntity_;
import com.ogoma.blog.iam.repositories.UserRepository;
import jakarta.persistence.criteria.JoinType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findOne((root, criteriaQuery, criteriaBuilder) -> {
            root.fetch(UserEntity_.ROLES, JoinType.LEFT);
            return criteriaBuilder.equal(criteriaBuilder.upper(root.get(UserEntity_.USERNAME)), username.toUpperCase());
        }).orElseThrow(() -> new UsernameNotFoundException("Invalid user credentials"));
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
