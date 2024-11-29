package com.javaacademy.calendar.event;

import lombok.Data;
import lombok.NonNull;

@Data
public class UpdateEventRq {
    @NonNull
    private Integer id;
    @NonNull
    private String title;
}
