import java.util.concurrent.*;

public class ArraySumMultiThreadV2 {
    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ExecutorService executor = Executors.newFixedThreadPool(2);
        int mid = array.length / 2;
        
        Future<Integer> future1 = executor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < mid; i++) {
                sum += array[i];
            }
            System.out.println("Поток 1 посчитал: " + sum);
            return sum;
        });
        
        Future<Integer> future2 = executor.submit(() -> {
            int sum = 0;
            for (int i = mid; i < array.length; i++) {
                sum += array[i];
            }
            System.out.println("Поток 2 посчитал: " + sum);
            return sum;
        });
        
        int totalSum = future1.get() + future2.get();
        System.out.println("Общая сумма: " + totalSum);
        executor.shutdown();
    }
}