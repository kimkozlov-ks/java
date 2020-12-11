package com.example.lab6122020.service;

import com.example.lab6122020.model.Mark;
import com.example.lab6122020.model.Markbook;
import com.example.lab6122020.model.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ReportService {

    private final DataGeneratorService dataGeneratorService;

    public ReportService(DataGeneratorService dataGeneratorService) {
        this.dataGeneratorService = dataGeneratorService;
    }

    public void report() {
        Markbook markbook = dataGeneratorService.generateMarkbook();

        log.info("Students {} markbook\n", markbook.getStudent().getName());
        for (Map.Entry<Subject, List<Mark>> entry : markbook.getMarksBySubject().entrySet()) {
            log.info("Subject {}:\n\t\"Average mark {};\n\t\"Max mark {};\n\tMin mark {}.\n",
                    entry.getKey().getTitle(),
                    average(entry.getValue()),
                    max(entry.getValue()),
                    min(entry.getValue()));

        }
    }

    private float average(List<Mark> marks) {
        return marks.stream().reduce(0, (acum, el) ->
                acum += el.getValue(), Integer::sum) / (marks.size() * 1.f);
    }

    private int max(List<Mark> marks) {
        return marks.stream().max(Comparator.comparingInt(Mark::getValue)).get().getValue();
    }

    private int min(List<Mark> marks) {
        return marks.stream().min(Comparator.comparingInt(Mark::getValue)).get().getValue();
    }
}
