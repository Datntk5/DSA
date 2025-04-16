
package Main;
public class Task {
    String name;
    String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', description='" + description + "'}";
    }
}

