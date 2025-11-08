package com.ogoma.blog.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public record EmailAddress(String value) implements Serializable {

    // A pragmatic email regex: local part allowed common characters, domain with at least one dot,
    // TLD of length >=2. Adjust if you need different rules.
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,}$"
    );

    /**
     * Compact constructor - validates and normalizes the email.
     *
     * @param value raw email string
     */
    public EmailAddress {
        Objects.requireNonNull(value, "email must not be null");
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("email must not be empty");
        }
        if (!EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException(String.format("Invalid email address: %s" , value));
        }
        // assign normalized value back to the record component
        value = normalized;
    }

    /**
     * Jackson factory for deserialization from a simple JSON string.
     * Example: mapper.readValue("\"user@example.com\"", EmailAddress.class)
     */
    @JsonCreator
    public static EmailAddress from(String email) {
        return new EmailAddress(email);
    }

    /**
     * Jackson value for serialization as a simple string.
     * Example: mapper.writeValueAsString(new EmailAddress("user@example.com")) -> "\"user@example.com\""
     */
    @JsonValue
    public String asString() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}



