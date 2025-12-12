package main;

import stack.CustomStack;
import exceptions.CustomEmptyStackException;


public class Main {
    public static void main(String[] args) {        
        // Создаем стек для целых чисел
        CustomStack<Integer> stack = new CustomStack<>();
        
        try {
            // Демонстрация работы со стеком
            System.out.println("1. Добавление элементов в стек:");
            stack.push(10);
            stack.push(20);
            stack.push(30);
            
            System.out.println("\n2. Просмотр состояния стека:");
            stack.display();
            System.out.println("Размер стека: " + stack.size());
            
            System.out.println("\n3. Извлечение элементов:");
            stack.pop();
            stack.pop();
            stack.pop();
            
            System.out.println("\n4. Попытка извлечь из пустого стека:");
            stack.pop(); //исключение
            
        } catch (CustomEmptyStackException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n5. Демонстрация восстановления после исключения:");
        stack.push(100);
        stack.push(200);
        stack.display();

    }
}