class SumCalculator extends Thread{
    private int[] array;
    private int start;
    private int end;
    private int partSum;

    public SumCalculator(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
        this.partSum = 0;
    }
    
    @Override
    public void run(){
        for(int i = start; i < end; i++){
            partSum+=array[i];
        }
    }
    public long getPartSum(){
        return partSum;
    }
}
public class ArraySumMultiThread{
    public static void main(String[] args) throws InterruptedException{
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = array.length/2;

        SumCalculator t1 = new SumCalculator(array, 0, mid);
        SumCalculator t2 = new SumCalculator(array, mid, array.length);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long totalSum = t1.getPartSum() + t2.getPartSum();
        System.out.println(totalSum);
    }
}