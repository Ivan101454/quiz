package by.ivan101454.quiz.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "quiz", schema = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;
    private String nameOfQuiz;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Card> cards;

    public void addCard(Card card) {
        card.setQuiz(this);
        cards.add(card);
    }

    public void deleteCard(Card card) {
        cards.remove(card);
    }
}
