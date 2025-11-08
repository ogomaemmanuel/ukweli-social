package com.ogoma.blog.auth;

import com.ogoma.blog.auth.dto.ForgotPasswordRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationRequestDto;
import com.ogoma.blog.auth.dto.UserRegistrationResponseDto;
import com.ogoma.blog.auth.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
@PreAuthorize(value = "isFullyAuthenticated()")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @PreAuthorize(value = "permitAll()")
    public ResponseEntity<UserRegistrationResponseDto> registerUser(@RequestBody @Valid UserRegistrationRequestDto registrationRequestDto) {
        return ResponseEntity.ok(this.authService.registerUser(registrationRequestDto));
    }

    @PostMapping("/forgot-password")
    @PreAuthorize(value = "permitAll()")
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid ForgotPasswordRequestDto forgotPasswordRequestDto) {
        this.authService.sendPasswordResetMail(forgotPasswordRequestDto);
        return ResponseEntity.ok("Password reset email sent to your email account");
    }
}
