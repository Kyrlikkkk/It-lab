class MaxFinder extends Thread{
    private int[] row;
    private int rowMax;

    public MaxFinder(int[] row){
        this.row = row;
        this.rowMax = Integer.MIN_VALUE;
    }
    @Override
    public void run(){
        for(int value : row){
            if(value > rowMax){
                rowMax = value;
            }
        }
    }
    public int gerRowMax(){
        return rowMax;
    }
}

public class MatrixMaxMultiThresd {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        MaxFinder[] threads = new MaxFinder[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            threads[i] = new MaxFinder(matrix[i]);
            threads[i]. start();
        }

        for(MaxFinder thread : threads){
            thread.join();
        }

        int totalMax = Integer.MIN_VALUE;
        for(MaxFinder thread : threads){
            if(thread.gerRowMax() > totalMax){
                totalMax = thread.gerRowMax();
            }
        }

        System.out.println(totalMax);
    }
}
