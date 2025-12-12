import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    List<Object> processors = new ArrayList<>();
    List<String> data;
    public void registerDataProcessor(Object processor){
        processors.add(processor);
    }
    // загружает данные из исходного источника
    public void loadData(String source) throws IOException{
        data = Files.readAllLines(Paths.get(source));
    }

    //многопоточная обработка данных
    public void processData(){
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for(Object processor : processors){
            futures.add(CompletableFuture.runAsync(()->{
                Method[] methods = processor.getClass().getDeclaredMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(DataProcessor.class)){
                        try {
                            method.setAccessible(true);
                            method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, executor));
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        }
        executor.shutdown();
    }
    
    public void saveData(String destinition) throws IOException{
        Files.write(Paths.get(destinition), data);
    }
    
}
