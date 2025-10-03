public abstract class Book{
    private static int CountOfObjects = 0;

    private String title;
    private String author;
    private int year;

    public Book() {
        this("Неизвестно", "Неизвестен", 2000);
    }

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;

        CountOfObjects++;
    }

    // Абстрактные методы 
    public abstract String getDescription();
    public abstract void play();
    
    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год: " + year);

    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }
        
    // Счетчик
    public static int getCountOfObjects() {
        return CountOfObjects;
    }
}