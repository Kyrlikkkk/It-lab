import java.util.*;
public class SalesManager {
    private Map<Product, Integer> sales = new HashMap<>();

    public void addSale(Product product, int quantity){
        sales.put(product, sales.getOrDefault(product, 0)+quantity);
    }

    public void displaySales(){
        System.out.println("Проданные товары:");
        for(Map.Entry<Product, Integer> entry: sales.entrySet()){
            System.out.println(entry.getKey() + "-" + entry.getValue() + "шт");
        }
    }

    public double getTotalRevenue(){
        double total = 0;
        for(Map.Entry<Product, Integer> entry: sales.entrySet()){
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Product getMostPopularProduct(){
        Product popular = null;
        int value = 0;
        for(Map.Entry<Product, Integer> entry: sales.entrySet()){
            if(entry.getValue()>value){
                value = entry.getValue();
                popular = entry.getKey();
            }
        }
        return popular;
    }
    public static void main(String[] args) {
        SalesManager manager = new SalesManager();
        
        Product p1 = new Product("Телефон", 10000);
        Product p2 = new Product("Ноутбук", 50000);
        Product p3 = new Product("Наушники", 2000);
        
        manager.addSale(p1, 5);
        manager.addSale(p2, 2);
        manager.addSale(p3, 10);
        manager.addSale(p1, 3);
        
        manager.displaySales();
        
        System.out.println("\nОбщая выручка: " + manager.getTotalRevenue() + " руб.");
        
        Product popular = manager.getMostPopularProduct();
        System.out.println("Самый популярный товар: " + popular);
    }
}
