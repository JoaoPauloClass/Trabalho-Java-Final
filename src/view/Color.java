package view;

public class Color {
    

    public static final String RESET_COLOR = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    


    public static String getResetColor() {
        return RESET_COLOR;
    }
    public static String getRed() {
        return RED;
    }
    public static String getGreen() {
        return GREEN;
    }
    public static String getBlue() {
        return BLUE;
    }
    public static String getYellow() {
        return YELLOW;
    }


    
}
