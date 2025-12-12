import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CapitalAfterLowercaseFinder {
    public static void main(String[] args) {
        String text = "Text ExaMPle FinD OooOo HeLlo WorLd";
        try{
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);
            StringBuilder result = new StringBuilder(text);
            int offset = 0; //смещение
            while(matcher.find()){
                int start = matcher.start() + offset;
                int end = matcher.end() + offset;
                result.insert(start, "!");
                offset +=1;
                result.insert(end+1, "!");
                offset += 1;
            }
            System.out.println(result.toString());

        }
        catch(PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении:" + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Произошла ошибка:" + e.getMessage());
        }
    }
}
