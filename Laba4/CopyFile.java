import java.io.*;

public class CopyFile {
    public static void main(String[] args) {        
        String sourcePath = args[0];
        String destPath = args[1];
        
        FileInputStream sourceFile = null;
        FileOutputStream destinationFile = null;
        
        try {
            // Открытие
            try {
                sourceFile = new FileInputStream(sourcePath);
                System.out.println("Исходный файл открыт: " + sourcePath);
            }  catch (FileNotFoundException e) {
                System.out.println("Исходный файл '" + sourcePath + "' не найден");
                return;
            } 
            
            try {
                destinationFile = new FileOutputStream(destPath);
                System.out.println("Целевой файл открыт: " + destPath);
            } catch (FileNotFoundException e) {
                System.out.println("Не удалось создать целевой файл '" + destPath + "'");
                return;
            } 
            
            // Копирование
            int byteData;
           if (sourceFile != null) {
                try {
                    sourceFile.close();
                    System.out.println("Исходный файл закрыт");
                } catch (IOException e) {
                    System.out.println("Предупреждение: Ошибка закрытия исходного файла: " + e.getMessage());
                }
            }
            try {
                while ((byteData = sourceFile.read()) != -1) {
                    destinationFile.write(byteData);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при копировании данных: " + e.getMessage());
                return;
            }
            
            System.out.println("Копирование завершено успешно.");
      
        } finally {
            // Зактытие
            if (sourceFile != null) {
                try {
                    sourceFile.close();
                    System.out.println("Исходный файл закрыт");
                } catch (IOException e) {
                    System.out.println("Предупреждение: Ошибка закрытия исходного файла: " + e.getMessage());
                }
            }
            
            if (destinationFile != null) {
                try {
                    destinationFile.close();
                    System.out.println("Целевой файл закрыт");
                } catch (IOException e) {
                    System.out.println("Предупреждение: Ошибка закрытия целевого файла: " + e.getMessage());
                }
            }
        }
    }
}