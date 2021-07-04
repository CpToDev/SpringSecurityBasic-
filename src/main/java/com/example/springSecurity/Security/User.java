package com.example.springSecurity.Security;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age ;
    private boolean admin;

}
