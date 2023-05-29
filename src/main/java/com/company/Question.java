package com.company;

public class Question {
    private int id;
    private String question;
    private String answer;

    public Question(int id, String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
