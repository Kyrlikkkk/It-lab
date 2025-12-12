import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMaxMultiThreadV2{
    public static void main(String[] args) throws Exception {
        int[][] matrix = {
            {3, 7, 12, 5},
            {9, 25, 4, 18},
            {14, 6, 21, 8},
            {11, 19, 2, 30}
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        int firstPart = matrix.length / 2 + matrix.length % 2;  
        int secondPart = matrix.length - firstPart;
        
        Future<Integer> future1 = executor.submit(() -> {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < firstPart; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
            System.out.println("Первая половина: максимум = " + max);
            return max;
        });
        
        Future<Integer> future2 = executor.submit(() -> {
            int max = Integer.MIN_VALUE;
            for (int i = secondPart; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
            System.out.println("Вторая половина: максимум = " + max);
            return max;
        });
        
        int max1 = future1.get();
        int max2 = future2.get();
        int globalMax = Math.max(max1, max2);
        System.out.println("\nНаибольший элемент в матрице: " + globalMax);
        
        executor.shutdown();
    }

}

