import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args){
        String text = "Alala Ululu 25.65 and 78,5 and 532 and -125 ";
        try{
            Pattern pattern = Pattern.compile("-?\\d+([.,]\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
                System.out.println(matcher.group());
            }
        }
        catch(PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении:" + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Произошла ошибка:" + e.getMessage());
        }
    }
}