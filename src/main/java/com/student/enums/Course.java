package com.student.enums;

public enum Course {

    COMPUTER_SCIENCE("Computer Science"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    APPLIED_COMPUTER_SCIENCE("Applied Computer Science");


    private String displayName;

    Course(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
