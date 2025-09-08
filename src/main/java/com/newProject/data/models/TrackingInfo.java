package com.newProject.data.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TrackingInfo {
    private LocalDateTime dateCreated;
    private String description;
}
