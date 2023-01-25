package org.example.repository;

import org.example.model.Log;

import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    public static List<Log> logs = new ArrayList<>();


    public static List<Log> getLogs() {
        return logs;
    }
    public static void setLogs(List<Log> logs) {
        LogRepository.logs = logs;
    }
}
