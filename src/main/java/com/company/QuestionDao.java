

package com.company;


import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    //Class.forName("org.sqlite.JDBC");


    private Connection connection;

    public QuestionDao() {
        try {
            String workingDirectory = System.getProperty("user.dir");
            String databasePath = workingDirectory + "/quiz.db";
            String jdbcUrl = "jdbc:sqlite:" + databasePath;
            connection = DriverManager.getConnection(jdbcUrl);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addQuestion(Question question){

        String sql = "INSERT INTO questions (question, answer) VALUES (?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getAnswer());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions(){
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try(PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String questionText = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                Question question = new Question(id, questionText, answer);
                questions.add(question);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
