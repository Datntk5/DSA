
package Lab04;
import java.util.ArrayList;

public class Lab04 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        // Print all objects using a for loop
        for (String item : myList) {
            System.out.println(item);
        }

        // Example of using get(), contains(), and size()
        System.out.println("Element at index 1: " + myList.get(1));
        System.out.println("Does the list contain 'Banana'? " + myList.contains("Banana"));
        System.out.println("Size of the list: " + myList.size());
    }
}

