package mx.kenzie.scribe;

import java.awt.*;

public record Colour(int red, int green, int blue) {

    public Colour(Color color) {
        this(color.getRed(), color.getGreen(), color.getBlue());
    }

    public Colour(String hex) {
        this(Colour.fromHex(hex));
    }

    public Colour(int color) {
        this((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
    }

    private static int fromHex(String hex) {
        final int start = hex.charAt(0) == '#' ? 1 : 0;
        return Integer.valueOf(hex.substring(start), 16);
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }

    public int color() {
        return ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
    }

    public String hex() {
        String red = Integer.toHexString(this.red);
        String green = Integer.toHexString(this.green);
        String blue = Integer.toHexString(this.blue);
        if (red.length() == 1) red = "0" + red;
        if (green.length() == 1) green = "0" + green;
        if (blue.length() == 1) blue = "0" + blue;
        return ("#" + red + green + blue).toUpperCase();
    }

}
