package com.afkl.exercises.spring.locations;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Value
public class Location {

    private String code, name, description;
    private Coordinates coordinates;
    private Location parent;
    private Set<Location> children;

}
