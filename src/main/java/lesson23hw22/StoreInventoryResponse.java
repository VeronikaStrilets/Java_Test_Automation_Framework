package lesson23hw22;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class StoreInventoryResponse {
    private Integer sold;
    private Integer pending;
    private Integer available;
    private Map<String, Integer> additionalProperties = new HashMap<>();

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Integer value) {
        this.additionalProperties.put(name, value);
    }

    public Map<String, Integer> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public String toString() {
        return "StoreInventoryResponse{" +
                "sold=" + sold +
                ", pending=" + pending +
                ", available=" + available +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
