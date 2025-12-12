public class Film extends Book {
    private String director;
    private int duration;
    private double rating;
    
    public Film() {
        super();
        director = "Неизвестен";
        duration = 0;
        rating = 0.0;
    }
    
    public Film(String title, String director, int year, int duration,double rating) {
        super(title, director, year); 
        this.director = director;
        this.duration = duration;
        this.rating = rating;
    }
    
    // Реализация абстрактных методов(полиморфизм)
    @Override
    public String getDescription() {
        return String.format("Фильм: '%s' (режиссер: %s, рейтинг: %.1f/10)", getTitle(), director, rating);
    }
    
    @Override
    public void play() {
        System.out.println("Запуск фильма: " + getTitle());
    }
    
  
    public String getRatingCategory() {
        if (rating >= 8.5) return "Высокий рейтинг";
        else if (rating >= 7.0) return "Хороший рейтинг";
        else if (rating >= 5.0) return "Средний рейтинг";
        else return "Низкий рейтинг";
    }
    
    public boolean isHighlyRated() {
        return rating >= 8.0;
    }
    
    // Геттеры и сеттеры
    public String getDirector() { return director;}
    public int getDuration(){ return duration;}
    public double getRating() { return rating;}
    
    
    public void setDirector(String director) { this.director = director; }    
    public void setDuration(int duration) { this.duration = duration;}
    public void setRating(double rating) { 
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        }
    }
    
    // Переопределение метода 
    @Override
    public void displayInfo() {
        System.out.println("Название: " + getTitle());
        System.out.println("Режиссер: " + director);
        System.out.println("Год выпуска: " + getYear());
        System.out.println("Рейтинг: " + rating + "/10 (" + getRatingCategory() + ")");
        System.out.println("Длительность фильма: " + duration);
    }
}