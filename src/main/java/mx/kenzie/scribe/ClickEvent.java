package mx.kenzie.scribe;

import mx.kenzie.argo.Json;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClickEvent extends TextEvent {

    public String action = "show_text";
    public String value;

    public ClickEvent() {
    }

    public <Type extends String> ClickEvent(Action<Type> action, Type contents) {
        this.action = action.toString();
        this.value = contents;
    }

    @Override
    public String toString() {
        return Json.toJson(this.toMap());
    }

    public Map<String, Object> toMap() {
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("action", action);
        if (value != null) map.put("value", value);
        return map;
    }

}
