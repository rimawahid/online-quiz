package com.rima.onlinequiz.controller;

import com.rima.onlinequiz.entity.Question;
import com.rima.onlinequiz.service.QuestionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/quizzes")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/create-new-question")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question createQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestion);
    }

    @GetMapping("/all-question")
    public ResponseEntity<List<Question>> getAllQuestion() {
        List<Question> questions = questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Question> question = questionService.getQuestionById(id);
        if (question.isPresent()) {
            return ResponseEntity.ok(question.get());
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question updateQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(updateQuestion);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects() {
        List<String> subject = questionService.getAllSubjects();
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/fetch-question-for-user")
    public ResponseEntity<List<Question>> getQuestionsFoeUser(@RequestParam Integer numOfQuestion,@RequestParam String subject) {
        List<Question> allQuestion = questionService.getQuestionForUser(numOfQuestion, subject);
        List<Question> multiQuestion = new ArrayList<>(allQuestion);
        Collections.shuffle(multiQuestion);

        int availableQuestions = Math.min(numOfQuestion, multiQuestion.size());
        List<Question> randomQuestion = multiQuestion.subList(0, availableQuestions);
        return ResponseEntity.ok(randomQuestion);
    }
}
