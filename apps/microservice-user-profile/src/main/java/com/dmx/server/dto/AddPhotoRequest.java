package com.dmx.server.dto;

public record AddPhotoRequest(
        String userId,
        String url,
        String type) {
}
