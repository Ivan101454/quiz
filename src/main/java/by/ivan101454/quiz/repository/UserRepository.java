package by.ivan101454.quiz.repository;

import by.ivan101454.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
