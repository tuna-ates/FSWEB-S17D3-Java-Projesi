package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koala {
    private long id;
    private String name;
    private int weight;
    private int sleepHour;
    private String gender;

}
