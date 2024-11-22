package by.ivan101454.quiz.service;

import by.ivan101454.quiz.dto.CardDto;
import by.ivan101454.quiz.entity.Card;
import by.ivan101454.quiz.mapper.CardEditMapper;
import by.ivan101454.quiz.mapper.EntityMapper;
import by.ivan101454.quiz.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardEditMapper cardEditMapper;
    private final ImageService imageService;

    public Optional<CardDto> findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return Optional.ofNullable(cardEditMapper.mapCardToCardDto(card.get(), new CardDto()));
    }

    public List<CardDto> findAll() {
        return cardRepository.findAll().stream().map(EntityMapper.INSTANCE::cardToCardDto).toList();
    }

    public Optional<Card> create(CardDto cardDto) {
        Card card = Optional.of(cardDto)
                .map(dto -> {
                    uploadImage(dto.getImage());
                    return dto;
                })
                .map(dto -> cardEditMapper.mapCardDtoToCard(new Card(), dto))
                .map(cardRepository::save)
                .orElseThrow();
        return Optional.of(card);
    }

    public Optional<Card> update(Long id, CardDto cardDto) {
        return cardRepository.findById(id).map(entity -> cardEditMapper.mapCardDtoToCard(entity, cardDto))
                .map(cardRepository::saveAndFlush);
    }

    public void delete(Long id) {
        cardRepository.findById(id).ifPresent(cardRepository::delete);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        if (!image.isEmpty()) {
            imageService.upload(image.getOriginalFilename(), image.getInputStream());
        }
    }

    public Optional<byte[]> findPicture(Long id) {
//        return cardRepository.findById(id).map(Card::getPicturePath).filter(StringUtils::hasText).flatMap(imageService::get);
        return cardRepository.findById(id).map(Card::getPicturePath).filter(StringUtils::hasText).flatMap(imageService::get);
    }
}
