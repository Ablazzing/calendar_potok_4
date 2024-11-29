package com.javaacademy.calendar.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@Builder
public class Event {
    private Integer id;
    private LocalDate date;
    private String description;
    private String title;
}
