package com.castlele.otpcreator.controller;

import com.castlele.otpcreator.dto.UserDto;
import com.castlele.otpcreator.dto.otp.OtpConfigDto;
import com.castlele.otpcreator.service.AdminService;
import com.castlele.otpcreator.service.UserService;
import com.castlele.otpcreator.service.otp.OtpConfigService;
import com.castlele.otpcreator.service.otp.OtpService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final OtpConfigService otpConfigService;
    private final UserService userService;
    private final OtpService otpService;
    private final AdminService adminService;

    @GetMapping("/config")
    public OtpConfigDto getOtpConfig() {
        return otpConfigService.getOtpConfigDto();
    }

    @PostMapping("/config")
    public OtpConfigDto create(@RequestBody OtpConfigDto req) {
        return otpConfigService.create(req);
    }

    @PutMapping("/config")
    public OtpConfigDto updateOtpConfig(@RequestBody OtpConfigDto req) {
        return otpConfigService.update(req);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@Valid @NotNull @Positive @PathVariable Long id) {
        adminService.deleteUserAndOtpCodes(id);
    }
}
