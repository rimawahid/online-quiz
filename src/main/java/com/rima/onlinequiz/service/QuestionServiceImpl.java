package com.rima.onlinequiz.service;

import com.rima.onlinequiz.entity.Question;
import com.rima.onlinequiz.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public Question createQuestion(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return repository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<String> getAllSubjects() {
        return repository.findDistinctSubject();
    }

    @Override
    public Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException {
        Optional<Question> oldQuestion = repository.findById(id);
        if (oldQuestion.isPresent()) {
            Question updatedQus = oldQuestion.get();
            updatedQus.setQuestionTittle(question.getQuestionTittle());
            updatedQus.setChoices(question.getChoices());
            updatedQus.setCorrectAnswers(question.getCorrectAnswers());
            return repository.save(updatedQus);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Question> getQuestionForUser(Integer numOfQuestion, String subject) {
        Pageable pageable = PageRequest.of(0, numOfQuestion);
        return repository.findBySubject(subject, pageable).getContent();
    }
}
