
package Main;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Run exercises individually
//        runExercise1(); // Call Bài 1
//        runExercise2(); // Call Bài 2
//        runExercise3(); // Call Bài 3
//        runExercise4(); // Call Bài 4
        runExercise5(); // Call Bài 5
    }

    // Exercise 1: Push Stack
    private static void runExercise1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(13);
        stack.push(89);
        stack.push(90);
        stack.push(11);
        stack.push(45);
        stack.push(18);
        System.out.println("Stack after pushing elements: " + stack);
    }

    // Exercise 2: Delete Stack and Search Element
    private static void runExercise2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(13);
        stack.push(89);
        stack.push(90);
        stack.push(11);
        stack.push(45);
        stack.push(18);

        // Pop 3 elements
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());

        // Search in stack
        System.out.println("Search for 89: " + (stack.contains(89) ? "Found" : "Not Found"));
        System.out.println("Search for 100: " + (stack.contains(100) ? "Found" : "Not Found"));
    }

    // Exercise 3: Loop Stack
    private static void runExercise3() {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(13);
        stack.push(89);
        stack.push(90);

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) == 13) {
                stack.set(i, 99);
                System.out.println("Changed value 13 to 99.");
            }
        }
        System.out.println("Stack after modification: " + stack);
    }

    // Exercise 4: Queue Manipulation
    private static void runExercise4() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Initial Queue: " + queue);
        System.out.println("First element: " + queue.peek());
        queue.poll();
        System.out.println("Queue after removing the first element: " + queue);
    }

    // Exercise 5: Task Processing with Queue
    private static void runExercise5() {
        TaskProcessor processor = new TaskProcessor();
        processor.enqueueTask(new Task("Task 1", "Description 1"));
        processor.enqueueTask(new Task("Task 2", "Description 2"));
        processor.processTasks();
    }
}

