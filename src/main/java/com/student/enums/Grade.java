package com.student.enums;

public enum Grade {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4")
    ;

    private final String label;


    Grade(String label) {
        this.label=label;
    }
}
