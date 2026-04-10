package com.dmx.infrastructure.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public abstract class EnvironmentConfig {
    ResourceLoader resourceLoader;

    public EnvironmentConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Dotenv dotenv() {
        Resource resource = resourceLoader.getResource("classpath:/.env.local");

        return Dotenv
            .configure()
            .directory("/")
            .filename(resource.exists() ? ".env.local" : ".env")
            .load();
    }
}
