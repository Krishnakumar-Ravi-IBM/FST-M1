package activities;

import java.util.HashMap;
import java.util.Map;

public class activity11 {
    public static void main(String[] args) {
        // Creating a map using the HashMap
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1,"Blue");
        colours.put(2,"Brown");
        colours.put(3,"Violet");
        colours.put(4,"Maroon");
        colours.put(5,"Green");
        System.out.println("The colours Map contains: "+colours);
        colours.remove(4);
        System.out.println("The colours Map after removal of Maroon color is: "+colours);
        System.out.println("Does the colours Map contains Green? "+colours.containsValue("Green"));
        System.out.println("The size of the Map is: "+colours.size());
    }
}
