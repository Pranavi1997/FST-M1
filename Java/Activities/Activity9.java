import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Emma");
        System.out.println("Names in the list:");
for (String name : myList) {
            System.out.println(name);
        }
String thirdName = myList.get(2);
        System.out.println("The 3rd name in the list is: " + thirdName);
        System.out.println("Is Pranavi is in list: " + myList.contains("Pranavi"));
        System.out.println("Size of ArrayList: " + myList.size());
        myList.remove("Bob");
        System.out.println("New Size of ArrayList: " + myList.size());
	}

}
