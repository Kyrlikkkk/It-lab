import java.util.HashMap;
import java.util.Map;

public class ProductTable2 {
    private Map<String, Product> table;
    
    public ProductTable2() {
        table = new HashMap<>();
    }
    
    // Вставка продукта
    public void put(String barcode, Product product) {
        table.put(barcode, product);
    }
    
    // Поиск продукта по штрихкоду
    public Product get(String barcode) {
        return table.get(barcode);
    }
    
    // Удаление продукта по штрихкоду
    public Product remove(String barcode) {
        return table.remove(barcode);
    }
     public static void main(String[] args) {
        ProductTable warehouse = new ProductTable();
        
        warehouse.put("5901234123457", new Product("Молоко", 85.50, 100));
        warehouse.put("5901234123458", new Product("Хлеб", 45.00, 50));
        warehouse.put("5901234123459", new Product("Сыр", 320.00, 30));
        warehouse.put("5901234123460", new Product("Яблоки", 120.00, 200));
        
        warehouse.displayAll();
        System.out.println();
        
        // Поиск продукта
        Product milk = warehouse.get("5901234123457");
        System.out.println("Найден " + milk);
        System.out.println();
        
        
        // Удаление продукта
        Product removed = warehouse.remove("5901234123460");
        System.out.println("Удален " + removed);
        System.out.println();
        
        warehouse.displayAll();
        System.out.println();
    }
}
