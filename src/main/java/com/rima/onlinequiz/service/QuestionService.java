package com.rima.onlinequiz.service;

import com.rima.onlinequiz.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestion();

    Optional<Question> getQuestionById(Long id);

    List<String> getAllSubjects();

    Question updateQuestion(Long id, Question question);

    void deleteQuestion(Long id);

    List<Question> getQuestionForUser(Integer numOfQuestion, String subject);
}
