package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital city of France?", "Paris"));
        questions.add(new Question("What is 2+2", "4"));

        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String userAnswer = scanner.nextLine();

            if(userAnswer.equalsIgnoreCase(question.getAnswer())){
                System.out.println("Correct answer!");
                score++;
            }
            else{
                System.out.println("Wrong answer.");
            }
        }

        System.out.println("Your score: "+score+"/"+questions.size());

    }

}
