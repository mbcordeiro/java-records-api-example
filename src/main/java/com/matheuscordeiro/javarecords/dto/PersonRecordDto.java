package com.matheuscordeiro.javarecords.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record PersonRecordDto(@NotNull @Size(max = 100) String name, 
    @NotNull @Size(min = 2) int age) {
    public static final String MESSAGE = "Hello World";

    public void printName() {
        System.out.println("Name: " + name);
    }

    public static void printMessage() {
        System.out.println(MESSAGE);
    }
}