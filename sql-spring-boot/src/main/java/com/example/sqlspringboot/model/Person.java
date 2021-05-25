package com.example.sqlspringboot.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Person {

    private String personId;
    private String personName;

}
