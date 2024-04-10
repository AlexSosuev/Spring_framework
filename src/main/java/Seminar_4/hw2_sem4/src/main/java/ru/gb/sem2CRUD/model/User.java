package ru.gb.sem2CRUD.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
}