package com.ogoma.blog.posts.entities;

public enum PostPublicationStatus {
    DRAFT("Draft"),ARCHIVED("Archive"),PUBLISHED("Publish");
    private String commandText;

    public String getCommandText() {
        return commandText;
    }

    private PostPublicationStatus(String commandText) {
        this.commandText = commandText;
    }

}
