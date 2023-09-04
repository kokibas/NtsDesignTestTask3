package com.example.ntsdesigntesttask3.controller;

import com.example.ntsdesigntesttask3.entity.LogMessage;
import com.example.ntsdesigntesttask3.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app")
public class WebSocketController {

    @Autowired
    private LogService logService;

    @MessageMapping("/addLog")
    @SendTo("/topic/logs")
    public LogMessage addLog(LogMessage logMessage) {
        return logService.addLog(logMessage);
    }

    @MessageMapping("/logs")
    @SendTo("/topic/logs")
    public List<LogMessage> getLogs() {
        return logService.getAllLogs();
    }
}
