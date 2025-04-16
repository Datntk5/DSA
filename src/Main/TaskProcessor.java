
package Main;
import java.util.LinkedList;
import java.util.Queue;

public class TaskProcessor {
    private Queue<Task> taskQueue = new LinkedList<>();

    public void enqueueTask(Task task) {
        taskQueue.add(task);
    }

    public void processTasks() {
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
    }
}
