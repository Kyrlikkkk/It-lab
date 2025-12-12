import java.util.*;
import java.util.concurrent.*;

class Product {
    private String name;
    private double weight;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() { return name; }
    public double getWeight() { return weight; }
    
    @Override
    public String toString() {
        return name + " (" + weight + "кг)";
    }
}

class Warehouse {
    private List<Product> products;
    
    public Warehouse(List<Product> products) {
        this.products = new ArrayList<>(products);
    }
    
    public synchronized Product takeProduct() {
        if(!products.isEmpty()){
            return products.remove(0);
        }
        return null;
    }
    
    public synchronized void returnProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }
    
    public synchronized boolean hasProducts() {
        return !products.isEmpty();
    }
    
    public synchronized int getProductCount() {
        return products.size();
    }
}

public class TransportingProducts {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;
    
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Холодильник", 50.5));
        productList.add(new Product("Стиральная машина", 45.2));
        productList.add(new Product("Телевизор", 15.8));
        productList.add(new Product("Диван", 80.3));
        productList.add(new Product("Кресло", 35.7));
        productList.add(new Product("Стол", 25.4));
        productList.add(new Product("Стул", 8.2));
        productList.add(new Product("Шкаф", 70.1));
        productList.add(new Product("Микроволновка", 12.6));
        productList.add(new Product("Компьютер", 18.9));
        
        Warehouse warehouse = new Warehouse(productList);
        ExecutorService workers = Executors.newFixedThreadPool(NUM_WORKERS);
        int tripNumber = 1;
        
        // Пока есть товары на складе
        while (warehouse.hasProducts()) {
            System.out.println("\n Поездка #" + tripNumber + " (осталось товаров: " + 
                             warehouse.getProductCount() + ")");
            
            // Для этой партии
            List<Product> currentLoad = Collections.synchronizedList(new ArrayList<>());
            double[] currentWeight = {0};
            List<Product> rejectedProducts = Collections.synchronizedList(new ArrayList<>());
            
            while (currentWeight[0] < MAX_WEIGHT && warehouse.hasProducts()) {
                @SuppressWarnings("unchecked")
                CompletableFuture<Void>[] tasks = new CompletableFuture[NUM_WORKERS];                
                for (int i = 0; i < NUM_WORKERS; i++) {                    
                    CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                        Product product = warehouse.takeProduct();
                        if (product != null) {
                            synchronized (currentLoad) {
                                if (currentWeight[0] + product.getWeight() <= MAX_WEIGHT) {
                                    currentLoad.add(product);
                                    currentWeight[0] += product.getWeight();
                                } else {
                                    rejectedProducts.add(product);
                                }
                            }
                        }
                    }, workers);
                    
                    tasks[i] = task;
                }
                
                CompletableFuture.allOf(tasks).join();
            }
            
            for (Product product : rejectedProducts) {
                warehouse.returnProduct(product);
            }
            
            if (currentLoad.isEmpty()) {
                System.out.println("Не смогли собрать партию - все оставшиеся товары слишком тяжелые!");
                break;
            }
            
            System.out.println("\nПартия собрана!");
            System.out.println("Товаров: " + currentLoad.size() + ", вес: " + 
                             String.format("%.1f", currentWeight[0]) + "кг");
            System.out.println("Состав: " + currentLoad);
            
            // Перевозим партию
            System.out.println("Грузчики везут товары на другой склад...");
            System.out.println("Поездка #" + tripNumber + " завершена!");
            tripNumber++; 
        }
        
        System.out.println("\n Все товары перевезены! Сделано " + (tripNumber-1) + " поездок");
        workers.shutdown();
    }
}