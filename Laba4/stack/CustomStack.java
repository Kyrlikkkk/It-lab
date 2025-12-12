package stack;

import exceptions.CustomEmptyStackException;
import logger.ExceptionLogger;
import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {
    private List<T> stack;
    private ExceptionLogger logger;
    
    public CustomStack() {
        this.stack = new ArrayList<>();
        this.logger = new ExceptionLogger("stack_exceptionss.log");
    }
    
    // Добавление элемента в стек
    public void push(T element) {
        stack.add(element);
        System.out.println("Добавлен элемент: " + element);
    }
    
    // Извлечение элемента из стека
    public T pop() {
        try {
            if (stack.isEmpty()) {
                throw new CustomEmptyStackException("Стек пуст. Невозможно извлечь элемент.");
            }
            T element = stack.remove(stack.size() - 1);
            System.out.println("Извлечен элемент: " + element);
            return element;
        } catch (CustomEmptyStackException e) {
            logger.logException(e);
            throw e;
        }
    }
    
    // Получение размера стека
    public int size() {
        return stack.size();
    }
    
    // Вывод содержимого стека
    public void display() {
        if (stack.isEmpty()) {
            System.out.println("Стек пуст");
        } else {
            System.out.println("Содержимое стека (сверху вниз): " + stack);
        }
    }
}