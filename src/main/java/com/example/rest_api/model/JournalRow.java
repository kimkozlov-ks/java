package com.example.rest_api.model;

import com.example.rest_api.enums.JournalRowStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class JournalRow {
    private UUID id;
    private LocalDate creationDate;
    private JournalRowStatus status;
    private String message;
}
