package by.ivan101454.quiz.mapper;

import by.ivan101454.quiz.dto.CardDto;
import by.ivan101454.quiz.entity.Card;
import by.ivan101454.quiz.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardEditMapper {

    private final CardRepository cardRepository;

    public Card mapCardDtoToCard(Card card, CardDto cardDto) {
        card.setName(cardDto.getName());
        card.setQuestion(cardDto.getQuestion());
        card.setRightAnswer(cardDto.getRightAnswer().toLowerCase().trim());
        card.setQuiz(cardDto.getQuiz());
        card.setAnswers(new ArrayList<>(List.of(cardDto.getAnswers().toLowerCase().trim().split(" "))));
        Optional.ofNullable(cardDto.getImage())
                .ifPresent(image -> card.setPicturePath(image.getOriginalFilename()));
        return card;
    }

    public CardDto mapCardToCardDto(Card card, CardDto cardDto) {
        cardDto.setId(card.getId());
        cardDto.setName(card.getName());
        cardDto.setQuestion(cardDto.getQuestion());
        cardDto.setRightAnswer(card.getRightAnswer());
        cardDto.setQuiz(card.getQuiz());
        cardDto.setAnswerList(card.getAnswers());
        cardDto.setNameOfImage(card.getPicturePath());
        return cardDto;
    }



}
