package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.Contact;
import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.location.domain.Location;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.photo.domain.Photo;
import com.dmx.profile.photo.domain.PhotoDTO;
import com.dmx.profile.role.domain.Role;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.shared.domain.events.UserProfileCreatedDomainEvent;
import com.dmx.profile.skill.domain.Skill;
import com.dmx.profile.skill.domain.SkillDTO;
import com.dmx.profile.status.domain.Status;
import com.dmx.shared.kernel.AggregateRoot;
import com.dmx.shared.kernel.Utils;

import java.util.*;

public final class UserProfile extends AggregateRoot {
    private final UserProfileId id;
    private final UserProfileName name;
    private final UserProfileNickname nickname;
    private final UserProfileEmail email;
    private final UserProfileAge age;
    private final UserProfileGender gender;
    private final UserProfileDescription description;
    private Status status;
    private List<Skill> skillList;
    private List<Location> locationList;
    private List<Contact> contactList;
    private List<Role> roleList;
    private Map<String, Photo> photoMap;

    public UserProfile(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            UserProfileDescription description,
            Status status,
            Map<String, Photo> photoMap,
            List<Skill> skillList,
            List<Location> locationList,
            List<Contact> contactList,
            List<Role> roleList
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
        this.roleList = roleList;
    }

    public UserProfile() {
        this.id = null;
        this.name = null;
        this.nickname = null;
        this.email = null;
        this.age = null;
        this.gender = null;
        this.description = null;
        this.status = null;
        this.photoMap = new HashMap<>();
        this.skillList = new ArrayList<>();
        this.locationList = new ArrayList<>();
        this.contactList = new ArrayList<>();
        this.roleList = new ArrayList<>();
    }

    public static UserProfile fromPrimitives(UserProfileDTO userProfile) {
        List<Location> locationList = new ArrayList<>();
        List<Contact> contactList = new ArrayList<>();
        List<Role> roleList = new ArrayList<>();
        List<Skill> skillList = new ArrayList<>();
        Map<String, Photo> photoMap = new HashMap<>();

        userProfile.getLocationList().forEach((location) -> locationList.add(Location.fromPrimitives(location)));
        userProfile.getContactList().forEach((contact) -> contactList.add(Contact.fromPrimitives(contact)));
        userProfile.getRoleList().forEach((role) -> roleList.add(Role.fromPrimitives(role)));
        userProfile.getSkillList().forEach((skill) -> skillList.add(Skill.fromPrimitives(skill)));
        userProfile.getPhotoMap().forEach((key, photo) -> photoMap.put(key, Photo.fromPrimitives(photo)));

        return new UserProfile(
                new UserProfileId(userProfile.getId()),
                new UserProfileName(userProfile.getName()),
                new UserProfileNickname(userProfile.getNickname()),
                new UserProfileEmail(userProfile.getEmail()),
                new UserProfileAge(userProfile.getAge()),
                new UserProfileGender(userProfile.getGender()),
                new UserProfileDescription(userProfile.getDescription()),
                Status.fromPrimitives(userProfile.getStatus()),
                photoMap,
                skillList,
                locationList,
                contactList,
                roleList
        );
    }

    public UserProfileDTO toPrimitives() {
        List<LocationDTO> locationList = new ArrayList<>();
        List<ContactDTO> contactList = new ArrayList<>();
        List<RoleDTO> roleList = new ArrayList<>();
        List<SkillDTO> skillList = new ArrayList<>();
        Map<String, PhotoDTO> photoMap = new HashMap<>();

        this.locationList.forEach(location -> locationList.add(location.toPrimitives()));
        this.contactList.forEach(contact -> contactList.add(contact.toPrimitive()));
        this.roleList.forEach(role -> roleList.add(role.toPrimitives()));
        this.skillList.forEach(skill -> skillList.add(skill.toPrimitives()));
        this.photoMap.forEach((key, photo) -> photoMap.put(key, photo.toPrimitives()));

        return new UserProfileDTO(
                this.id.value(),
                this.name.value(),
                this.nickname.value(),
                this.email.value(),
                this.age.value(),
                this.gender.value(),
                this.description.value(),
                this.status.toPrimitives(),
                photoMap,
                skillList,
                locationList,
                contactList,
                roleList
        );
    }

    public static UserProfile create(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            UserProfileDescription description,
            Status status
    ) {
        UserProfile userProfile = new UserProfile(id, name, nickname, email, age, gender, description, status, new HashMap<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userProfile.record(new UserProfileCreatedDomainEvent(
                id.value(),
                name.value(),
                nickname.value(),
                "none",
                description.value()
        ));
        return userProfile;
    }

    public void addPhotos(Photo photo) {
        this.photoMap.put(photo.getType().value(), photo);
    }

    public void addContact(List<Contact> contacts) {
        this.contactList.clear();
        this.contactList.addAll(contacts);
    }

    public void addLocation(List<Location> locations) {
        this.locationList = locations;
    }

    public void addRole(List<Role> roles) {
        this.roleList = roles;
    }

    public void addSkills(List<Skill> skills) {
        this.skillList = skills;
    }

    public UserProfileId getId() {
        return id;
    }

    public UserProfileName getName() {
        return name;
    }

    public UserProfileNickname getNickname() {
        return nickname;
    }

    public UserProfileEmail getEmail() {
        return email;
    }

    public UserProfileAge getAge() {
        return age;
    }

    public UserProfileGender getGender() {
        return gender;
    }

    public Status getStatus() {
        return status;
    }

    public UserProfileDescription getDescription() {
        return description;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public Map<String, Photo> getPhotoMap() {
        return photoMap;
    }

    public void setPhotoMap(Map<String, Photo> photoMap) {
        this.photoMap = photoMap;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
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
