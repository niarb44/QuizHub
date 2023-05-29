package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private List<Question> questions;
    private int score;

    public QuizApplication(){
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

public void runQuiz(){
    Scanner scanner = new Scanner(System.in);

    for(Question question : questions){
        System.out.println(question.getQuestion());
        String userAnswer = scanner.nextLine();

        if(userAnswer.equals(question.getAnswer())){
            System.out.println("Correct answer!");
            score++;
        } else{
            System.out.println("Wrong answer!");
        }
    }

    System.out.println("Quiz finished. Your score is: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.addQuestion(new Question("What is the capital of France?", "Paris"));
        quizApp.addQuestion(new Question("What is 2 + 2?", "4"));

        quizApp.runQuiz();
    }

}