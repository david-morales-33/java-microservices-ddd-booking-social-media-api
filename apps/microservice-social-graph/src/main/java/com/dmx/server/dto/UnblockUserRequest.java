package com.dmx.server.dto;

public record UnblockUserRequest(String userId, String blockedId) {
}
