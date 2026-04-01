package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.bus.command.Command;

public final class CreateUserProfileCommand implements Command {
    private final String id;
    private final String name;
    private final String nickname;
    private final String email;
    private final Integer age;
    private final String description;
    private final String gender;

    public CreateUserProfileCommand(String id, String name, String nickname, String email, Integer age, String gender, String description) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }
}
