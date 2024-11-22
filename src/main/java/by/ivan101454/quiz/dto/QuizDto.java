package by.ivan101454.quiz.dto;

import by.ivan101454.quiz.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDto {
    private Long id;
    private String nameOfQuiz;
    private List<Card> cards;
}
