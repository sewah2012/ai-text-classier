package io.undefvar.text_classification_service.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.stereotype.Service;

@Service
public class TextClassifierService implements ITextClassifier{
    private final ChatClient chatClient;

    public TextClassifierService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(
                    ChatOptionsBuilder.builder()
                        .withTemperature(0.0f)
                        .build()
                )
                .build();


    }

    @Override
    public String classify(String text) {
        return chatClient
                .prompt()
                .system("""
                        Classify the provided text into one of these classes:
                        BUSINESS, SPORT, TECHNOLOGY, OTHER.
                        """)
                .user(text)
                .call()
                .content();
    }
}
