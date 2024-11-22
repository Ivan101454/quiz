package by.ivan101454.quiz.repository;

import by.ivan101454.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
