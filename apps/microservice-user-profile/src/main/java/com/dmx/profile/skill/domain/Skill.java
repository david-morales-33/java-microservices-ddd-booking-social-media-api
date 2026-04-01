package com.dmx.profile.skill.domain;

import java.util.Objects;

public final class Skill {
    private final SkillId id;
    private final SkillLabel label;

    public Skill(SkillId id, SkillLabel label) {
        this.id = id;
        this.label = label;
    }

    public Skill() {
        this.id = null;
        this.label = null;
    }

    public static Skill create(SkillId id, SkillLabel label) {
        return new Skill(id, label);
    }

    public static Skill fromPrimitives(SkillDTO skill) {
        return new Skill(
                new SkillId(skill.id()),
                new SkillLabel(skill.label())
        );
    }

    public SkillDTO toPrimitives() {
        return new SkillDTO(this.id.value(), this.label.value());
    }

    public SkillId getId() {
        return id;
    }

    public SkillLabel getLabel() {
        return label;
    }

    public boolean compareByContent(SkillLabel label) {
        return this.label.equals(label);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return label.equals(skill.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", label=" + label + '}';
    }
}
