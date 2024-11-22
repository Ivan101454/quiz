package by.ivan101454.quiz.service;

import by.ivan101454.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
}
