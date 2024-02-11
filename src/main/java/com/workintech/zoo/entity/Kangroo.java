package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
public class Kangroo {
    private long id;
    private String name;
    private int weight;
    private int height;
    private String gender;
    private boolean isAggressive;

}
