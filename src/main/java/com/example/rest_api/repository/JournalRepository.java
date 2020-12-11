package com.example.rest_api.repository;

import com.example.rest_api.configuration.JournalConfiguration;
import com.example.rest_api.model.JournalRow;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JournalRepository {

    private final List<JournalRow> journal;

    public JournalRepository(JournalConfiguration journalConfiguration) {
        this.journal = journalConfiguration.getJournal();
    }

    public List<JournalRow> getRows(int offset, int limit)
    {
        return journal.stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public UUID addRow(JournalRow journalRow)
    {
        UUID id = UUID.randomUUID();

        if(id != null)
        {
            journalRow.setId(id);
            journal.add(journalRow);
        }

        return id;
    }

    public boolean deleteRow(String id) {
        return journal.removeIf(row -> row.getId().toString().equals(id));
    }
}
