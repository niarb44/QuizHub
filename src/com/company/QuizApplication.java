package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private List<Question> questions;
    private List<Question> wrongAnswers;
    private int score;

    public QuizApplication(){
        questions = new ArrayList<>();
        wrongAnswers = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

public void runQuiz() {
    Scanner scanner = new Scanner(System.in);

    for (Question question : questions) {
        System.out.println(question.getQuestion());
        String userAnswer = scanner.nextLine();

        if (userAnswer.equals(question.getAnswer())) {
            System.out.println("Correct answer!");
            score++;
        } else {
            System.out.println("Wrong answer! The correct answer is: " + question.getAnswer());
            wrongAnswers.add(question);
        }
    }

    System.out.println("\nQuiz finished. Your score is: " + score + "/" + questions.size());

    if (!wrongAnswers.isEmpty()) {
        System.out.println("Incorrect answers:");
        for (Question wrongAnswer : wrongAnswers) {
            System.out.println(wrongAnswer.getQuestion() + " = " + wrongAnswer.getAnswer());
        }

    }
}

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.addQuestion(new Question("What is the capital of France?", "Paris"));
        quizApp.addQuestion(new Question("What is 2 + 2?", "4"));
        quizApp.addQuestion(new Question("How many planets are there in our solar system?", "8"));
        quizApp.addQuestion(new Question("What is the tallest mountain in our solar system?", "Mount Everest"));
        quizApp.addQuestion(new Question("Which planet is know as the Red Planet?", "Mars"));
        quizApp.addQuestion(new Question("Who is the author of the novel '1984'", "George Orwell"));
        quizApp.addQuestion(new Question("What is the currency of Germany?", "Euro"));
        quizApp.addQuestion(new Question("Which famous scientist developed the theory of relativity?", "Albert Einstein"));
        quizApp.addQuestion(new Question("How many players are there on a soccer team?", "11"));
        quizApp.addQuestion(new Question("Who is the founder of Microsoft", "Bill Gates"));

        quizApp.runQuiz();
    }

}