import java.util.Scanner;
import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                System.out.println("Пароль коректный!");
            } else{
                checkPasswordDetails(input);
            }
        }
        catch(PatternSyntaxException e){
            System.out.println("Ошибка в регулярном выражении:" + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Произошла ошибка:" + e.getMessage());
        }
        scanner.close();
    }
        public static void checkPasswordDetails(String password) {
        System.out.println("Некоректный пароль!"); 
        if (password.length() < 8) {
            System.out.println("- Слишком короткий пароль (меньше 8 символов)");
        }
        if (password.length() > 16) {
            System.out.println("- Слишком длинный пароль (больше 16 символов)");
        }
        
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("- Отсутствуют заглавные буквы");
        }
        
        if (!password.matches(".*\\d.*")) {
            System.out.println("- Отсутствуют цифры");
        }
        
        if (!password.matches("[A-Za-z\\d]*")) {
            System.out.println("- Содержит недопустимые символы");
        }}
}
