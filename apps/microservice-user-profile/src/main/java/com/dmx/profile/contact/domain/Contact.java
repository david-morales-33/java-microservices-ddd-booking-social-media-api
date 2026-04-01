package com.dmx.profile.contact.domain;

import java.util.Objects;

public final class Contact {
    private final ContactId id;
    private final ContactContent content;

    public Contact(ContactId id, ContactContent content) {
        this.id = id;
        this.content = content;
    }

    public Contact() {
        this.id = null;
        this.content = null;
    }

    public static Contact create(ContactId id, ContactContent content) {
        return new Contact(id, content);
    }

    public static Contact fromPrimitives(ContactDTO contact) {
        return new Contact(
                new ContactId(contact.id()),
                new ContactContent(contact.content())
        );
    }

    public ContactDTO toPrimitive() {
        return new ContactDTO(this.id.value(), this.content.value());
    }

    public ContactId getId() {
        return id;
    }

    public ContactContent getContent() {
        return content;
    }

    public boolean compareByContent(ContactContent content) {
        return this.content.equals(content);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id) && content.equals(contact.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
