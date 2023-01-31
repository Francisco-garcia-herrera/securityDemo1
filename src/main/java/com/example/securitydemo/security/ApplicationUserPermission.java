package com.example.securitydemo.security;

public enum ApplicationUserPermission {
    TEST_READER("test:reader"),
    SEND_REPORT("send:report"),
    EDIT_QUESTION("edit:question");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
