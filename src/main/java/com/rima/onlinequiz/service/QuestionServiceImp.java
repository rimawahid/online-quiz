package com.rima.onlinequiz.service;

import com.rima.onlinequiz.entity.Question;
import java.util.List;
import java.util.Optional;

public class QuestionServiceImp implements QuestionService{
    @Override
    public Question createQuestion(Question question) {
        return null;
    }

    @Override
    public List<Question> getAllQuestion() {
        return null;
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<String> getAllSubjects() {
        return null;
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public List<Question> getQuestionForUser(Integer numOfQuestion, String subject) {
        return null;
    }
}
