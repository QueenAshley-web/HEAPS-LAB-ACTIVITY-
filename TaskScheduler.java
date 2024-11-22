import java.util.PriorityQueue;

// Class representing a task
class Task implements Comparable<Task> {
    private String name;
    private int deadline; // Lower deadline means higher priority

    public Task(String name, int deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public int getDeadline() {
        return deadline;
    }

    @Override
    public int compareTo(Task other) {
        // Min-heap: task with the earliest deadline is processed first
        return Integer.compare(this.deadline, other.deadline);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', deadline=" + deadline + "}";
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        // Priority Queue to act as a Min-Heap
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Add tasks to the queue
        taskQueue.add(new Task("Submit assignment", 2)); // Deadline: 2 hours
        taskQueue.add(new Task("Prepare for meeting", 1)); // Deadline: 1 hour
        taskQueue.add(new Task("Finish project", 4)); // Deadline: 4 hours
        taskQueue.add(new Task("Buy groceries", 3)); // Deadline: 3 hours

        // Process tasks in order of their deadlines
        System.out.println("Scheduling tasks based on deadlines:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll(); // Remove task with earliest deadline
            System.out.println("Processing: " + task);
        }
    }
}