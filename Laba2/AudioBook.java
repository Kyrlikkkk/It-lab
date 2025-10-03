public class AudioBook extends Book {
    private String narrator; 
    private String audioFormat;
    private int bitrate; 
    
    public AudioBook() {
        super();
        narrator = "Неизвестен";
        audioFormat = "MP3";
        bitrate = 128;
    }
    
    public AudioBook(String title, String author, int year, String narrator, String audioFormat, int bitrate) {
        super(title, author, year);
        this.narrator = narrator;
        this.audioFormat = audioFormat;
        this.bitrate = bitrate;
    }
    
    @Override
    public String getDescription() {
        return String.format("Аудиокнига: '%s' (автор: %s, чтец: %s, %d мин)", getTitle(), getAuthor(), narrator);
    }
    
    @Override
    public void play() {
        System.out.println("Воспроизведение аудиокниги: " + getTitle());
    }
    
    public String getAudioQuality() {
        if (bitrate >= 256) return "Высокое";
        else if (bitrate >= 128) return "Среднее";
        else return "Низкое";
    }
    
    public void changeNarrator(String narrator){
            this.narrator = narrator;
            System.out.println("Чтец: " + narrator);
    }
    // Геттеры и сеттеры 
    public String getNarrator() { return narrator; }
    public String getAudioFormat() { return audioFormat; }
    public int getBitrate() { return bitrate; }


    public void setNarrator(String narrator) { this.narrator = narrator; }
    public void setAudioFormat(String audioFormat) { this.audioFormat = audioFormat; }
    public void setBitrate(int bitrate) { 
        if (bitrate > 0) this.bitrate = bitrate; 
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип: Аудиокнига");
        System.out.println("Чтец: " + narrator);
        System.out.println("Формат: " + audioFormat);
        System.out.println("Качество: " + bitrate + " kbps" + "(" + getAudioQuality() + ")");
    }
}

