package logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {
    private String logFileName;
    
    public ExceptionLogger(String fileName) {
        this.logFileName = fileName;
    }
    
    public void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            writer.println("ИСКЛЮЧЕНИЕ");
            writer.println("Время: " + timestamp);
            writer.println("Тип: " + e.getClass().getSimpleName());
            writer.println("Сообщение: " + e.getMessage());
            writer.println();
            
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в лог-файл: " + ioException.getMessage());
        }
    }
}