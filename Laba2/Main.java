import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Принцип инкапсуляции:");
        AudioBook audioBook = new AudioBook();
        audioBook.setTitle("Мастер и Маргарита");
        audioBook.setAuthor("Михаил Булгаков");
        audioBook.setYear(1966);
        audioBook.setNarrator("Вениамин Смехов");
        audioBook.setAudioFormat("MP3");//доступ только через методы
        
        System.out.println("Название: " + audioBook.getTitle());
        System.out.println("Автор: " + audioBook.getAuthor());
        System.out.println();
        
        // Демонстрация принципа наследования
        System.out.println("Принцип наследования:");
        Film film = new Film("Престиж", "Кристофер Нолан", 2006, 130, 9);
        film.displayInfo(); // Метод унаследован от Book, но переопределен в Film
        System.out.println();
        
        // Демонстрация принципа полиморфизма
        System.out.println("Принцип полиморфизма:");
        Book[] books = new Book[2];
        books[0] = new AudioBook("1984", "Джордж Оруэлл", 1949, "Игорь Князев", "MP3", 180 );
        books[1] = new Film("Начало", "Кристофер Нолан", 2010, 148, 8.8);//Объекты классов-наследников могут рассматриваться как объекты базового класса
        
        for (Book book : books) {
            book.displayInfo(); // Один метод, разное поведение
        }
        System.out.println();

        // Ввод данных от пользователя
        System.out.println("Ввод данных:");
        
        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        
        System.out.print("Введите режисера: ");
        String author = scanner.nextLine();
        
        System.out.print("Введите год выпуска: ");
        int year = scanner.nextInt();
        
        System.out.print("Введите длительность фильма: ");
        int duration = scanner.nextInt();
        
        System.out.print("Введите рейтинг: ");
        double rating = scanner.nextDouble();
        
        Film userFilm = new Film(title, author, year, duration, rating);
        
        System.out.println("\n Созданный Фильм:");
        userFilm.displayInfo();

        System.out.println("\n Общее количество созданных объектов: " + Book.getCountOfObjects());
        
        scanner.close();
    }
}