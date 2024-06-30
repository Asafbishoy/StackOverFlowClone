package com.asaf.StackOverflowClone.Model;

public class Question {
    @Document(collection = "questions")
    public class Question {
        @Id
        private String id;
        private String title;
        private String content;
        private List<String> tags;
        private String userId;
        // Getters and Setters
    }
}
