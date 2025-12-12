import java.util.LinkedList;

public class HashTable<K, V> {
      public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        
        hashTable.put("apple", 10);
        hashTable.put("banana", 20);
        hashTable.put("orange", 30);
        
        System.out.println("Размер: " + hashTable.size());
        System.out.println("Пустая? " + hashTable.isEmpty()); 
        
        System.out.println("apple: " + hashTable.get("apple")); 
        System.out.println("banana: " + hashTable.get("banana")); 
        
        hashTable.remove("banana");
        System.out.println("Размер после удаления: " + hashTable.size()); 
        System.out.println("banana: " + hashTable.get("banana")); 
    }
    
    // Внутренний класс для хранения пар ключ-значение(не использует поля внешнего класса, не ссылаемся на него, не зависит от конкретного объекта внешнего класса)
    private static class Entry<K, V> {
        private K key;
        private V value;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {return key;}
        public V getValue() {return value;}
        public void setValue(V value) {this.value = value;}
    }
    
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int count = 16;
    
    // Конструктор
    public HashTable() {
        table = new LinkedList[count];
        size = 0;
    }
    
    // Хэш-функция
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    // добавляет или обновляет пару ключ-значение
    public void put(K key, V value) {
        int index = hash(key);
        
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }
    
    // возвращает значение по ключу
    public V get(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        
        return null;
    }
    
    // Метод remove - удаляет пару по ключу
    public V remove(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                table[index].remove(entry);
                size--;
                return value;
            }
        }
        
        return null;
    }
    
    // Метод size - возвращает количество элементов
    public int size() {
        return size;
    }
    
    // Метод isEmpty - проверяет, пуста ли таблица
    public boolean isEmpty() {
        return size == 0;
    }
}