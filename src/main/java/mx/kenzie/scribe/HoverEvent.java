package mx.kenzie.scribe;

import mx.kenzie.argo.meta.Any;
import mx.kenzie.argo.meta.Optional;

import java.util.LinkedHashMap;
import java.util.Map;

public class HoverEvent extends TextEvent {

    public @Any
    @Optional Contents contents;

    public HoverEvent() {
    }

    public <Type extends Contents> HoverEvent(Action<Type> action, Type contents) {
        this.action = action.toString();
        this.contents = contents;
    }

    @Override
    public Map<String, Object> toMap() {
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("action", action);
        if (contents != null) map.put("contents", contents.toMap());
        return map;
    }

}
