package com.example.jmsspringbootwk12;

import java.io.Serializable;

public class StructuredMsg implements Serializable {
    private String name;
    private String message;

    public StructuredMsg() {}

    public StructuredMsg(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "From: " + name + " - Message: " + message;
    }
}
