package by.ivan101454.quiz.dto;

import by.ivan101454.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
    private Long id;
    private String name;
    private String question;
    private String answers;
    private List<String> answerList;
    private String rightAnswer;
    private Quiz quiz;
    private MultipartFile image;
    private String nameOfImage;
}
