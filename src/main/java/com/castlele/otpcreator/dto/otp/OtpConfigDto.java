package com.castlele.otpcreator.dto.otp;

/**
 * DTO for {@link com.castlele.otpcreator.model.otp.OtpConfig}
 */
public record OtpConfigDto(Integer codeLength, Long ttlSeconds) {
}
