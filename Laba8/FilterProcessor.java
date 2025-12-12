import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public void removeEmpty(List<String> data) {
        List<String> filtered = data.stream()
            .filter(str -> str != null && !str.trim().isEmpty())
            .collect(Collectors.toList());
        data.clear();
        data.addAll(filtered);
    }
}
