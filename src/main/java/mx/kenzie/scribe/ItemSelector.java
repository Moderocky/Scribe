package mx.kenzie.scribe;

import mx.kenzie.argo.Json;
import mx.kenzie.grammar.Optional;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemSelector implements Contents {
    public ResourcePath id;
    public int count;
    public @Optional Object tag;

    public ItemSelector() {
        this.id = ResourcePath.of("stone");
    }

    public ItemSelector(ResourcePath key, int amount) {
        this.id = key;
        this.count = amount;
    }

    @Override
    public String toString() {
        return Json.toJson(this.toMap());
    }

    public Map<String, Object> toMap() {
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id.toString());
        if (count > 0) map.put("count", count);
        // todo NBT 'tag' string
        return map;
    }

}
