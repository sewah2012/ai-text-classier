package io.undefvar.text_classification_service.controllers;

import io.undefvar.text_classification_service.services.TextClassifierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextClassificationController {
    private final TextClassifierService textClassifierService;

    public TextClassificationController(TextClassifierService textClassifierService) {
        this.textClassifierService = textClassifierService;
    }

    @PostMapping("/classify")
    ResponseEntity<String> classify(@RequestBody String text){
        return ResponseEntity.ok(textClassifierService.classify(text));
    }

    @PostMapping("/test")
    String test(@RequestBody String text){
        return "working";
    }
}
