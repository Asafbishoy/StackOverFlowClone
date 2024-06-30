package com.asaf.StackOverflowClone.Model;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    // Getters and Setters
}

