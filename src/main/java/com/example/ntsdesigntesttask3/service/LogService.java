package com.example.ntsdesigntesttask3.service;

import com.example.ntsdesigntesttask3.entity.LogMessage;
import com.example.ntsdesigntesttask3.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogMessage addLog(LogMessage logMessage) {
        logMessage.setTimestamp(LocalDateTime.now());
        return logRepository.save(logMessage);
    }

    public List<LogMessage> getAllLogs() {
        return logRepository.findAll();
    }
}


