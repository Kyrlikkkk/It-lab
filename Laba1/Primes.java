/*Создайте программу, которая находит и выво
дит все простые числа меньше 100. */

public class Primes {
    public static void main(String args[]){
       System.out.println("Простые числа меньше 100:");
       for(int number = 2; number < 100; number ++){
        if (isPrime(number)) {
            System.out.println(number + "");
        }
       }
    }

     public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        
        return true; 
    }
}
