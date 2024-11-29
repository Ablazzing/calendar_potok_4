package com.javaacademy.calendar.controller;

import com.javaacademy.calendar.event.Event;
import com.javaacademy.calendar.event.UpdateEventRq;
import com.javaacademy.calendar.service.EventStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/event")
public class EventController {
    private final EventStorage eventStorage;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveEvent(@RequestBody Event event) {
        eventStorage.save(event);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Integer id) {
        return eventStorage.getById(id).orElseThrow();
    }

    @GetMapping
    public List<Event> getAllEvent() {
        return eventStorage.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteEventById(@PathVariable Integer id) {
        return eventStorage.deleteById(id);
    }

    @PatchMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateEventTitle(@RequestBody UpdateEventRq event) {
        eventStorage.changeEventTitleById(event.getId(), event.getTitle());
    }

    @GetMapping("/search")
    public List<Event> getEventsByDate(@RequestParam(required = false) LocalDate date) {
        return eventStorage.getAllByDate(date);
    }

}
