package com.asaf.StackOverflowClone.Model;

@Document(collection = "answers")
public class Answer {
    @Id
    private String id;
    private String content;
    private String questionId;
    private String userId;
    // Getters and Setters
}
