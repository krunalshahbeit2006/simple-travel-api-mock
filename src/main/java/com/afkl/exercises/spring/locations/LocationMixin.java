package com.afkl.exercises.spring.locations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

abstract class LocationMixin {

    @JsonCreator
    LocationMixin(@JsonProperty("code") String code,
                  @JsonProperty("name") String name,
                  @JsonProperty("description") String description,
                  @JsonProperty("coordinates") Coordinates coordinates,
                  @JsonProperty("parent") Location parent,
                  @JsonProperty("children") Set<Location> children) {
    }

}
