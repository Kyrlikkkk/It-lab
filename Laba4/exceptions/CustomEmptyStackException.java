package exceptions;

public class CustomEmptyStackException extends RuntimeException {
    public CustomEmptyStackException() {
        super("Ошибка: попытка извлечь элемент из пустого стека");
    }
    
    public CustomEmptyStackException(String message) {
        super(message);
    }
}