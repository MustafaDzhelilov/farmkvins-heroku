package com.example.projectsoftuni.model.service;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SearchFromToKgAcceptedFooderServiceModel {

    private Long id;
    private LocalDate start;
    private LocalDate end;
    private Long number;

    public SearchFromToKgAcceptedFooderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
