import java.util.List;

public class AggregateProcessor {
    @DataProcessor
    public void addCount(List<String> data) {
        data.add("Total lines: " + data.size());
    }
    
}
