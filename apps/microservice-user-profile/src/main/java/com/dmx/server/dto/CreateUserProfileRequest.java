package com.dmx.server.dto;

public record CreateUserProfileRequest(
         String id,
         String name,
         String nickname,
         String email,
         Integer age,
         String gender,
         String description
) {
}
