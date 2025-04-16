
package Lab04;
public class DivisibleBy7Not5 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        for (int i = 10; i <= 200; i++) {
            if (i % 7 == 0 && i % 5 != 0) {
                result.append(i).append(", ");
            }
        }

        // Remove the last comma and space
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }

        System.out.println("Numbers: " + result);
    }
}
