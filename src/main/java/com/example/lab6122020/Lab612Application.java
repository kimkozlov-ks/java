package com.example.lab6122020;

import com.example.lab6122020.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Lab612Application {

    private final ReportService reportService;

    public Lab612Application(ReportService reportService) {
        this.reportService = reportService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab612Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void report(){
        reportService.report();
    }
}
