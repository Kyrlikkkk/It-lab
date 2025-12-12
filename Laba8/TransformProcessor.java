import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public void toUpperCase(List<String> data) {
        List<String> transformed = data.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        data.clear();
        data.addAll(transformed);
    }
}
