package com.example.rest_api.controllers;

import com.example.rest_api.model.JournalRow;
import com.example.rest_api.repository.JournalRepository;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalRepository journalRepository;

    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping
    public ResponseEntity<List<JournalRow>> getRows(
            @RequestParam int offset,
            @RequestParam int limit)
    {
        List<JournalRow> journalRows = journalRepository.getRows(offset, limit);

        if(journalRows.isEmpty()) {
            return new ResponseEntity<>(journalRows, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(journalRows, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRow(@RequestBody JournalRow journalRow) {
        UUID id = journalRepository.addRow(journalRow);

        if(id == null)
        {
            return new ResponseEntity<>(id.toString(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(id.toString(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRow(@RequestBody String id){
        boolean isDeleted = journalRepository.deleteRow(id);

        if(!isDeleted) {
            return new ResponseEntity<>("Не найдена запись в журнале с ID=" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
