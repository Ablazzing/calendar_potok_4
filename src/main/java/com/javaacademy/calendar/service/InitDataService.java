package com.javaacademy.calendar.service;

import com.javaacademy.calendar.event.Event;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InitDataService {
    private final EventStorage eventStorage;

    @PostConstruct
    public void init() {
        Event event1 = createEvent("Др друга №1", "Ура туса у друга №1");
        Event event2 = createEvent("Др друга №2", "Ура туса у друга №2");
        eventStorage.save(event1);
        eventStorage.save(event2);
    }

    private Event createEvent(String title, String description) {
        return Event.builder()
                .date(LocalDate.now())
                .title(title)
                .description(description)
                .build();
    }
}
