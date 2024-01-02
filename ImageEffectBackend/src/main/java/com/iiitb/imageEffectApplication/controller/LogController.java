package com.iiitb.imageEffectApplication.controller;

import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * This class is responsible for handling requests related to logs.
 */
@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired // This annotation is used to automatically initialize the field with the bean
               // matching the type
    private LoggingService loggingService; // Service used to handle log-related requests

    @GetMapping("") // This method handles GET requests to /logs
    public List<LogModel> getAllLogs() { // This method returns a list of all logs
        return loggingService.getAllLogs();
    }

    @GetMapping("/{effectName}") // This method handles GET requests to /logs/{effectName}
    public List<LogModel> getLogsByEffect(@PathVariable String effectName) {
        return loggingService.getLogsByEffect(effectName);
    }

    @DeleteMapping("") // This method handles DELETE requests to /logs
    public ResponseEntity<String> clearLogs() {
        loggingService.clearLogs();
        return ResponseEntity.ok("Logs cleared successfully");
    }

    @GetMapping("/between-timestamps") // This method handles GET requests to /logs/between-timestamps
    public List<LogModel> getLogsBetweenTimestamps(@RequestParam String startTime, @RequestParam String endTime) {
        // Parse the timestamps to LocalDateTime, you may need to adjust the date-time
        // format
        LocalDateTime startTimestamp = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime endTimestamp = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);

        return loggingService.getLogsBetweenTimestamps(startTimestamp, endTimestamp);
    }
}
