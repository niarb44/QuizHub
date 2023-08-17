package com.example.QuizHub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public DataLoader(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Question question1 = new Question();
        question1.setContent("What is the capital of France?");
        List<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("London", false));
        answers1.add(new Answer("Paris", true));
        answers1.add(new Answer("Berlin", false));
        question1.setAnswers(answers1);

        Question question2 = new Question();
        question2.setContent("Which planet is known as the Red Planet?");
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("Earth", false));
        answers2.add(new Answer("Mars", true));
        answers2.add(new Answer("Jupiter", false));
        question2.setAnswers(answers2);

        Question question3 = new Question();
        question3.setContent("What is the largest mammal?");
        List<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("Elephant", false));
        answers3.add(new Answer("Blue Whale", true));
        answers3.add(new Answer("Giraffe", false));
        question3.setAnswers(answers3);

        questionRepository.saveAll(Arrays.asList(question1, question2, question3));
    }
}

