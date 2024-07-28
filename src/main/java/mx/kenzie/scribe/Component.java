package mx.kenzie.scribe;

import mx.kenzie.argo.Json;
import mx.kenzie.grammar.Any;
import mx.kenzie.grammar.Name;
import mx.kenzie.grammar.Optional;

import java.util.LinkedHashMap;
import java.util.Map;

public class Component implements Contents {

    public @Optional String text, insertion, font, translate, keybind;
    public @Optional Component[] extra, with;
    public @Optional boolean obfuscated, bold, italic, underlined, strikethrough;
    public @Any
    @Optional TextEvent hoverEvent, clickEvent;
    public @Name("color")
    @Optional Colour colour;

    public Component(String text, Colour colour) {
        this(text);
        this.colour = colour;
    }

    public Component(String text) {
        this();
        this.text = text;
    }

    public Component() {
    }

    public Component(String text, Colour colour, Component... components) {
        this(text, components);
        this.colour = colour;
    }

    public Component(String text, Component... components) {
        this(text);
        this.extra = components;
    }

    @Override
    public String toString() {
        return Json.toJson(this.toMap());
    }

    public Map<String, Object> toMap() {
        final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (text != null) map.put("text", text);
        if (obfuscated) map.put("obfuscated", true);
        if (bold) map.put("bold", true);
        if (italic) map.put("italic", true);
        if (underlined) map.put("underlined", true);
        if (strikethrough) map.put("strikethrough", true);
        if (hoverEvent != null) map.put("hoverEvent", hoverEvent.toMap());
        if (clickEvent != null) map.put("clickEvent", clickEvent.toMap());
        if (insertion != null) map.put("insertion", insertion);
        if (colour != null) map.put("color", colour.hex());
        return map;
    }

    public class Builder implements Contents {

        public Builder text(String text) {
            Component.this.text = text;
            Component.this.translate = null;
            Component.this.keybind = null;
            return this;
        }

        public Builder translate(String translate) {
            Component.this.text = null;
            Component.this.translate = translate;
            Component.this.keybind = null;
            return this;
        }

        public Builder keybind(String keybind) {
            Component.this.text = null;
            Component.this.translate = null;
            Component.this.keybind = keybind;
            return this;
        }

        public Builder insertion(String insertion) {
            Component.this.insertion = insertion;
            return this;
        }

        public Builder bold(boolean bold) {
            Component.this.bold = bold;
            return this;
        }

        public Builder italic(boolean italic) {
            Component.this.italic = italic;
            return this;
        }

        public Builder underlined(boolean underlined) {
            Component.this.underlined = underlined;
            return this;
        }

        public Builder strikethrough(boolean strikethrough) {
            Component.this.strikethrough = strikethrough;
            return this;
        }

        public Builder obfuscated(boolean obfuscated) {
            Component.this.obfuscated = obfuscated;
            return this;
        }

        public Builder colour(Colour colour) {
            Component.this.colour = colour;
            return this;
        }

        public Builder colour(int color) {
            Component.this.colour = new Colour(color);
            return this;
        }

        public Builder colour(int red, int green, int blue) {
            Component.this.colour = new Colour(red, green, blue);
            return this;
        }

        public Builder hoverEvent(Component show) {
            Component.this.hoverEvent = new HoverEvent(TextEvent.Action.SHOW_TEXT, show);
            return this;
        }

        public Builder hoverEvent(HoverEvent hoverEvent) {
            Component.this.hoverEvent = hoverEvent;
            return this;
        }

        public Builder clickEvent(ClickEvent clickEvent) {
            Component.this.clickEvent = clickEvent;
            return this;
        }

        public Builder extra(Component... components) {
            Component.this.extra = components;
            return this;
        }

        public Component finish() {
            return Component.this;
        }

        @Override
        public Map<String, Object> toMap() {
            return Component.this.toMap();
        }

        @Override
        public String toString() {
            return Component.this.toString();
        }

    }

}
