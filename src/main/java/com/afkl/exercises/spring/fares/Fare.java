package com.afkl.exercises.spring.fares;

import lombok.Value;

@Value
public class Fare {

    double amount;
    Currency currency;
    String origin, destination;

}
