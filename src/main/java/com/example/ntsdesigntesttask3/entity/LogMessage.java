package com.example.ntsdesigntesttask3.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class LogMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime timestamp;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
