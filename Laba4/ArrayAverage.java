public class ArrayAverage{
    public static void main(String[] args){
        Object[] arr = {1, 2, 3.5, 4, 5, 10, 15};
        int sum = 0;
        double average = 0;
        try{
            for(int i = 0; i< arr.length; i++){
                if(arr[i] instanceof Double | arr[i] instanceof Integer){
                    sum+= (Double) arr[i];
                } else{
                    throw new NumberFormatException("Элемент с индексом " + i + " не является числом: " + arr[i]);
                }
            }
            average = (double)sum/arr.length;

            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка: Выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());

        }
    }
}