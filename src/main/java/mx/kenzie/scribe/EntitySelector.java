package mx.kenzie.scribe;

import mx.kenzie.argo.Json;
import mx.kenzie.argo.meta.Optional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class EntitySelector implements Contents {

    public @Optional String name;
    public ResourcePath type;
    public UUID id;

    public EntitySelector() {
        this.type = ResourcePath.of("pig");
        this.id = UUID.randomUUID();
    }

    public EntitySelector(ResourcePath key, UUID id) {
        this.type = key;
        this.id = id;
    }

    @Override
    public String toString() {
        return Json.toJson(this.toMap());
    }

    public Map<String, Object> toMap() {
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (name != null) map.put("name", name);
        map.put("type", type);
        map.put("id", id.toString());
        return map;
    }

}
