package mx.kenzie.scribe;

import mx.kenzie.argo.Json;

import java.util.Map;

public abstract class TextEvent {
    public String action;

    @Override
    public String toString() {
        return Json.toJson(this.toMap());
    }

    public abstract Map<String, Object> toMap();

    public static class Action<Type> {
        public static final Action<Component> SHOW_TEXT = new Action<>("show_text");
        public static final Action<EntitySelector> SHOW_ENTITY = new Action<>("show_entity");
        public static final Action<ItemSelector> SHOW_ITEM = new Action<>("show_item");
        public static final Action<String>
            OPEN_URL = new Action<>("open_url"),
            OPEN_FILE = new Action<>("open_file"),
            RUN_COMMAND = new Action<>("run_command"),
            SUGGEST_COMMAND = new Action<>("suggest_command"),
            CHANGE_PAGE = new Action<>("change_page"),
            COPY_TO_CLIPBOARD = new Action<>("copy_to_clipboard");

        private final String name;

        Action(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
