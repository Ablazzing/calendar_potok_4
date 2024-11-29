package com.javaacademy.calendar.service;

import com.javaacademy.calendar.event.Event;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class EventStorage {
    private final Map<Integer, Event> data = new HashMap<>();
    private Integer count = 0;

    public void save(Event event) {
        count++;
        event.setId(count);
        data.put(count, event);
    }

    public Optional<Event> getById(Integer id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Event> getAll() {
        return data.values().stream().toList();
    }

    public boolean deleteById(Integer id) {
        return data.remove(id) != null;
    }

    public void changeEventTitleById(Integer id, String title) {
        if (data.containsKey(id)) {
            Event event = data.get(id);
            event.setTitle(title);
        } else {
            throw new RuntimeException("Объекта с таким id нет");
        }
    }

    public List<Event> getAllByDate(LocalDate date) {
        return data.values().stream()
                .filter(event -> Objects.equals(event.getDate(), date))
                .toList();
    }
}
