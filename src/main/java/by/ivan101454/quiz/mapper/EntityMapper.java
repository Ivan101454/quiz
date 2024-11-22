package by.ivan101454.quiz.mapper;


import by.ivan101454.quiz.dto.CardDto;
import by.ivan101454.quiz.dto.QuizDto;
import by.ivan101454.quiz.dto.UserDto;
import by.ivan101454.quiz.entity.Card;
import by.ivan101454.quiz.entity.Quiz;
import by.ivan101454.quiz.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

    QuizDto quizToQuizDto(Quiz quiz);
    Quiz quizDtoToQuiz(QuizDto quizDto);

    CardDto cardToCardDto(Card card);
    Card cardDtoToCard(CardDto cardDto);



}
