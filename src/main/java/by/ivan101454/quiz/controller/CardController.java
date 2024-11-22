package by.ivan101454.quiz.controller;

import by.ivan101454.quiz.dto.CardDto;
import by.ivan101454.quiz.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public String findCard(@PathVariable("id") Long id, Model model) {
        Optional<CardDto> byId = cardService.findById(id);
        byId.ifPresent(cardDto -> model.addAttribute("card", cardDto));
        return "cards/card";
    }
    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("cards", cardService.findAll());
        return "cards/allcard";
    }
    @GetMapping("/{id}/picture")
    public byte[] findPicture(@PathVariable("id") Long id) {
        if (cardService.findPicture(id).isPresent()) {
            return cardService.findPicture(id).get();
        } else return new byte[0];
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("card", new CardDto());
        return "cards/create-card";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute CardDto cardDto) {
        cardService.create(cardDto);
        return "redirect:/cards/create";
    }
}
