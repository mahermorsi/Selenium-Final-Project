package Logic;

import java.util.Map;

public class ItemBodyRequest {
    private String store;
    private int isClub;
    private String supplyAt;
    private Map<String, String> items;
    private Object meta;
    public ItemBodyRequest() {
    }

    public ItemBodyRequest(String store, int isClub, String supplyAt, Map<String, String> items, Object meta) {
        this.store = store;
        this.isClub = isClub;
        this.supplyAt = supplyAt;
        this.items = items;
        this.meta = meta;
    }
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getIsClub() {
        return isClub;
    }

    public void setIsClub(int isClub) {
        this.isClub = isClub;
    }

    public String getSupplyAt() {
        return supplyAt;
    }

    public void setSupplyAt(String supplyAt) {
        this.supplyAt = supplyAt;
    }

    public Map<String, String> getItems() {
        return items;
    }

    public void setItems(Map<String, String> items) {
        this.items = items;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        // Append store
        sb.append("\"store\": ").append(store).append(", ");

        // Append isClub
        sb.append("\"isClub\": ").append(isClub).append(", ");

        // Append supplyAt
        sb.append("\"supplyAt\": \"").append(supplyAt).append("\", ");

        // Append items
        sb.append("\"items\": {");
        for (Map.Entry<String, String> entry : items.entrySet()) {
            sb.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        // Remove the trailing comma and space
        if (!items.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");

        // Append meta
       // if (meta != null) {
            sb.append(", \"meta\": ").append(meta);
       // }

        sb.append("}");

        return sb.toString();
    }
}
