package com.castlele.otpcreator.service;

import com.castlele.otpcreator.dto.UserDto;
import com.castlele.otpcreator.model.user.User;
import com.castlele.otpcreator.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public String register(UserDto request) {
        User user = userService.create(request);
        log.info("User register: {}", user);
        return jwtTokenProvider.generateToken(user);
    }

    public String login(UserDto request) {
        User user = userService.findByUsername(request.username());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        log.info("Authentication successful: {}", user.getUsername());
        return jwtTokenProvider.generateToken(user);
    }
}
