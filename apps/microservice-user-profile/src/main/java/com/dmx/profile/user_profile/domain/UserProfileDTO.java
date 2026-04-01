package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.photo.domain.PhotoDTO;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.skill.domain.SkillDTO;
import com.dmx.profile.status.domain.StatusDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class UserProfileDTO implements Serializable {
    private final String id;
    private final String name;
    private final String nickname;
    private final String email;
    private final Integer age;
    private final String gender;
    private final String description;
    private final StatusDTO status;
    private final Map<String, PhotoDTO> photoMap;
    private final List<SkillDTO> skillList;
    private final List<LocationDTO> locationList;
    private final List<ContactDTO> contactList;
    private final List<RoleDTO> roleList;

    public UserProfileDTO(
            String id,
            String name,
            String nickname,
            String email,
            Integer age,
            String gender,
            String description,
            StatusDTO status,
            Map<String, PhotoDTO> photoMap,
            List<SkillDTO> skillList,
            List<LocationDTO> locationList,
            List<ContactDTO> contactList,
            List<RoleDTO> roleLis
    ) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photoMap = photoMap;
        this.status = status;
        this.skillList = skillList;
        this.locationList = locationList;
        this.contactList = contactList;
        this.roleList = roleLis;
    }

    private UserProfileDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.age = builder.age;
        this.gender = builder.gender;
        this.description = builder.description;
        this.photoMap = builder.photoMap;
        this.status = builder.status;
        this.skillList = builder.skillList;
        this.locationList = builder.locationList;
        this.contactList = builder.contactList;
        this.roleList = builder.roleList;
    }

    public static class Builder {
        private String id;
        private String name;
        private String nickname;
        private String email;
        private Integer age;
        private String gender;
        private String description;
        private StatusDTO status;
        private Map<String, PhotoDTO> photoMap;
        private List<SkillDTO> skillList;
        private List<LocationDTO> locationList;
        private List<ContactDTO> contactList;
        private List<RoleDTO> roleList;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder status(StatusDTO status) {
            this.status = status;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder locationList(List<LocationDTO> locationList) {
            this.locationList = locationList;
            return this;
        }

        public Builder contactList(List<ContactDTO> contactList) {
            this.contactList = contactList;
            return this;
        }

        public Builder roleList(List<RoleDTO> roleList) {
            this.roleList = roleList;
            return this;
        }

        public Builder skillList(List<SkillDTO> skillList) {
            this.skillList = skillList;
            return this;
        }

        public Builder photoMap(Map<String, PhotoDTO> photoMap) {
            this.photoMap = photoMap;
            return this;
        }

        public UserProfileDTO build() {
            return new UserProfileDTO(this);
        }
    }

    public static Builder builder() {
        return new Builder();
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

    public StatusDTO getStatus() {
        return status;
    }

    public List<SkillDTO> getSkillList() {
        return skillList;
    }

    public Map<String, PhotoDTO> getPhotoMap() {
        return photoMap;
    }

    public List<LocationDTO> getLocationList() {
        return locationList;
    }

    public List<ContactDTO> getContactList() {
        return contactList;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDTO that = (UserProfileDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                email.equals(that.email) &&
                age.equals(that.age) &&
                gender.equals(that.gender) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, email, age, gender, description);
    }
}
