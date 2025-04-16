
package Lab03;
public class RecursionAlgorithms {
    // Recursive factorial function
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        }
        return n * factorial(n - 1); // Recursive call
    }

    // Iterative factorial function
    public static long iterativeFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Compare recursive and iterative methods
    public static void compareRecursiveAndIterative(int n) {
        // Recursive method
        long startTime = System.nanoTime();
        long recursiveResult = factorial(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Factorial of " + n + ": " + recursiveResult +
                           " (Time: " + (endTime - startTime) + " ns)");

        // Iterative method
        startTime = System.nanoTime();
        long iterativeResult = iterativeFactorial(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Factorial of " + n + ": " + iterativeResult +
                           " (Time: " + (endTime - startTime) + " ns)");
    }

    // Main function
    public static void main(String[] args) {
        System.out.println("Best case (n = 0 or 1):");
        compareRecursiveAndIterative(0);
        compareRecursiveAndIterative(1);

        System.out.println("\nAverage case (n = 5):");
        compareRecursiveAndIterative(5);

        System.out.println("\nWorst case (n = 100):");
        compareRecursiveAndIterative(100);
    }
}

