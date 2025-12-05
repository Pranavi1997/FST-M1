import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> result = new HashSet<String>();
		result.add("Apple");
		result.add("Banana");
		result.add("Cherry");
		result.add("Date");
		result.add("Fig");
		result.add("Orange");
		System.out.println("Original HashSet: " + result);    
		System.out.println("Size of HashSet: " + result.size());
		result.remove("Fig");
		System.out.println("Removing Fig from HashSet: " + result.remove("Fig"));
		if(result.remove("Grapes")) {
        	System.out.println("Grapes removed from the Set");
        } else {
        	System.out.println("Grapes is not present in the Set");
        }
		 System.out.println("Checking if Orange is present: " + result.contains("Orange"));
	        System.out.println("Updated HashSet: " + result);
	}

}
