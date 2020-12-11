package com.example.rest_api.configuration;

import com.example.rest_api.enums.JournalRowStatus;
import com.example.rest_api.model.JournalRow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class JournalConfiguration {

    private List<JournalRow> journal;

    @Bean
    public List<JournalRow> getJournal(){
        if(journal != null)
        {
            return journal;
        }

        journal = new ArrayList<>();

        journal.add(JournalRow.builder()
                .id(UUID.randomUUID())
                .status(JournalRowStatus.INPROGRESS)
                .message("some row1")
                .creationDate(LocalDate.now())
                .build());
        journal.add(JournalRow.builder()
                .id(UUID.randomUUID())
                .status(JournalRowStatus.INPROGRESS)
                .message("some row2")
                .creationDate(LocalDate.now())
                .build());
        journal.add(JournalRow.builder()
                .id(UUID.randomUUID())
                .status(JournalRowStatus.WAITING)
                .message("some row3")
                .creationDate(LocalDate.now())
                .build());

        return journal;
    }


}
