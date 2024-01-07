package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoggingService {
    ArrayList<LogModel> logs = new ArrayList<LogModel>();

    public void addLog(String fileName, String effectName, String optionValues) {
        Date date = Calendar.getInstance().getTime();

        // Create a SimpleDateFormat object with your desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the date using the SimpleDateFormat
        String timestamp = dateFormat.format(date);

        // Add the log to the logs list
        logs.add(new LogModel(timestamp, fileName, effectName, optionValues));

        // Write the log to the masterlog.txt file
        writeLogToFile(timestamp, fileName, effectName, optionValues);

        return;
    }

    private void writeLogToFile(String timestamp, String fileName, String effectName, String optionValues) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("masterlog.txt", true))) {
            // Append the log to the masterlog.txt file
            writer.println(timestamp + " | " + fileName + " | " + effectName + " | " + optionValues);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<LogModel> readLogsFromFile() {
        ArrayList<LogModel> fileLogs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("masterlog.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the log line based on the delimiter (assuming "|")
                String[] parts = line.split("\\s*\\|\\s*");

                // Extract the log details
                String timestamp = parts[0].trim();
                String fileName = parts[1].trim();
                String effectName = parts[2].trim();
                String optionValues = parts[3].trim();

                // Create a LogModel and add it to the list
                fileLogs.add(new LogModel(timestamp, fileName, effectName, optionValues));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLogs;
    }


    public ArrayList<LogModel> getAllLogs()
    {
        ArrayList <LogModel> allLogs = new ArrayList<LogModel>();
        allLogs.clear();
        allLogs = readLogsFromFile(); 
        //allLogs.addAll(logs); 
        return  allLogs;
    }

    public List<LogModel> getLogsByEffect(String effectName)
    {
        ArrayList <LogModel> effectlogs = new ArrayList<LogModel>();
        effectlogs.clear();
        ArrayList <LogModel> alogs = new ArrayList<LogModel>();
        alogs.clear();
        alogs = getAllLogs();
        for (LogModel log : alogs)
        {
            if (log.getEffectName().equals(effectName))
            {
                effectlogs.add(log);
            }
        }
        return effectlogs;
    }

    public void clearLogs() {
        // Clear the in-memory logs list
        logs.clear();

        // Clear the logs in the masterlog.txt file
        try (PrintWriter writer = new PrintWriter("masterlog.txt")) {
            // Write an empty string to clear the file
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime)
    {
        ArrayList <LogModel> timeLogs = new ArrayList<LogModel>();
        timeLogs.clear();
        ArrayList <LogModel> tlogs = new ArrayList<LogModel>();
        tlogs.clear();
        tlogs = getAllLogs();
        for (LogModel log : tlogs)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime logTime = LocalDateTime.parse(log.getTimestamp() , formatter);

            if (logTime.isAfter(startTime) && logTime.isBefore(endTime))
            {
                //System.out.println("Log time: " + logTime);
                timeLogs.add(log);
            }
        }
        return timeLogs;
    }

    // public static void main(String[] args) {
    //     LoggingService loggingService = new LoggingService();

    //     // Create a thread for LoggingService
    //     Thread loggingThread = new Thread(loggingService);
    //     loggingThread.start();

    //     //new Thread(() -> loggingService.addLog("file1", "effect1", "value1")).start();
    //     new Thread(() -> {
    //         try {
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //         loggingService.addLog("file2", "effect2", "value2");
    //     }).start();

    //     new Thread(() -> {
    //         // Example of using one of the existing functions
    //         List<LogModel> allLogs = loggingService.getAllLogs();
    //         //System.out.println("All Logs: " + allLogs);
    //     }).start();
    // }

}