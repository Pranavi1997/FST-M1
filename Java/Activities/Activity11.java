import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> colors = new HashMap<>();
colors.put(1, "Red");
colors.put(2, "Blue");
colors.put(3, "Green");
colors.put(4, "Yellow");
colors.put(5, "Purple");
System.out.println("The Original map: " + colors);
colors.remove(4);
System.out.println("After removing Yellow: " + colors);
if(colors.containsValue("Green")) {
    System.out.println("Green exists in the Map");
} else {
    System.out.println("Green does not exist in the Map");
}
System.out.println("Size of the Map: " + colors.size());

	}

}
