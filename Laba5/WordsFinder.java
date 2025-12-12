import java.util.Scanner;
import java.util.regex.*;

public class WordsFinder {
    public static void main(String[] args) {
            String text = "Text about text oao example try find buterfly";
            System.out.println("Слова на какую букву искать?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            try{
                Pattern p = Pattern.compile("\\b" + input + "\\w*\\b", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(text);
                while (m.find()) {
                System.out.println(m.group());
            }
            scanner.close();
            }
            catch(PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении:" + e.getMessage());
            }
            catch(Exception e){
                System.out.println("Произошла ошибка:" + e.getMessage());
            }

    }
    
}
