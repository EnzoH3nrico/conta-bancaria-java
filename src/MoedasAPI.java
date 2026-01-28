import java.util.Map;

public record MoedasAPI(String base_code, Map<String, Double> conversion_rates) {
}
