
package Lab04;
import java.util.ArrayList;
import java.util.Scanner;

public class FindAndDelete {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John Doe");
        names.add("Jane Smith");
        names.add("Alice Brown");

        System.out.println("Original list: " + names);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to delete: ");
        String nameToDelete = scanner.nextLine();

        if (names.remove(nameToDelete)) {
            System.out.println("Updated list: " + names);
        } else {
            System.out.println("Name not found!");
        }
    }
}

