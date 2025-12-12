import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (validateIPAddress(input)) {
            System.out.println("IP-адрес корректен!");
        } else {
            System.out.println("IP-адрес некорректен!");
        }
        scanner.close();

}
    public static boolean validateIPAddress(String ipAddress) {
        
        try {
            Pattern pattern = Pattern.compile("(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])");
            Matcher matcher = pattern.matcher(ipAddress);
            return matcher.matches();
            
        } catch (PatternSyntaxException e) {
            System.out.println("ќшибка в регул€рном выражении: " + e.getMessage());
            return false;
        }
    }
}