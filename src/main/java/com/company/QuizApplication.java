package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private List<com.company.Question> questions;
    private List<String> wrongAnswers;
    private int score;
    private long startTime;

    public QuizApplication(){
        questions = new ArrayList<>();
        wrongAnswers = new ArrayList<>();
        score = 0;
        startTime = 0;
    }

    public void addQuestion(com.company.Question question){
        questions.add(question);
    }

public void runQuiz() {

    if(questions.isEmpty()) {
        System.out.println("No questions available.");
        return;
    }

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of questions you want to answer (1-" + questions.size() + "): ");
    int numQuestions = scanner.nextInt();

    if(numQuestions <= 0 || numQuestions > questions.size()) {
        System.out.println("Invalid number of questions.");
        return;
    }

    scanner.nextLine();

    List<com.company.Question> randomizedQuestions = new ArrayList<>(questions);
    Collections.shuffle(randomizedQuestions);

    System.out.println("Quiz starting...");

    startTime = System.currentTimeMillis();

    for (int i=0; i<numQuestions; i++) {
        com.company.Question question = randomizedQuestions.get(i);
        System.out.println(question.getQuestion());
        String userAnswer = scanner.nextLine();

        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            System.out.println("Correct answer!");
            score++;
        } else {
            System.out.println("Wrong answer! The correct answer is: " + question.getAnswer());
            wrongAnswers.add(question.getQuestion());
        }
    }

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;

    System.out.println("\nQuiz finished. Your score is: " + score + "/" + numQuestions);
    System.out.println("Total time taken: " + elapsedTime/1000 + " seconds.");

    if (!wrongAnswers.isEmpty()) {
        System.out.println("Incorrect answers:");
        for (String wrongAnswer : wrongAnswers) {
            System.out.println(wrongAnswer);
        }
    }
}

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        QuestionDao questionDao = new QuestionDao();
        questionDao.addQuestion(new Question(1, "What is the capital of France?", "Paris"));
        questionDao.addQuestion(new Question(2,"What is 2 + 2?", "4"));
        questionDao.addQuestion(new Question(3,"How many planets are there in our solar system?", "8"));
        questionDao.addQuestion(new Question(4, "What is the tallest mountain in our solar system?", "Mount Everest"));
        questionDao.addQuestion(new Question(5, "Which planet is know as the Red Planet?", "Mars"));
        questionDao.addQuestion(new Question(6, "Who is the author of the novel '1984'", "George Orwell"));
        questionDao.addQuestion(new Question(7,"What is the currency of Germany?", "Euro"));
        questionDao.addQuestion(new Question(8,"Which famous scientist developed the theory of relativity?", "Albert Einstein"));
        questionDao.addQuestion(new Question(9, "How many players are there on a soccer team?", "11"));
        questionDao.addQuestion(new Question(10, "Who is the founder of Microsoft", "Bill Gates"));

        List<Question> questions = questionDao.getAllQuestions();

        for (Question question : questions) {
            quizApp.addQuestion(question);
        }

        quizApp.runQuiz();

        questionDao.close();
    }
}

