package com.castlele.otpcreator.controller;

import com.castlele.otpcreator.dto.otp.GenerateCodeRequestDto;
import com.castlele.otpcreator.dto.otp.ValidateCodeRequestDto;
import com.castlele.otpcreator.service.otp.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/otp")
public class OtpController {

    private final OtpService otpService;

    @PostMapping
    public String generateOtpCode(@RequestBody GenerateCodeRequestDto req) {
        return otpService.generateOtpCode(req);
    }

    @PostMapping("/validate")
    public void validateOtpCode(@RequestBody ValidateCodeRequestDto req) {
        otpService.validateCode(req);
    }
}
