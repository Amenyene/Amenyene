public class ToDoListApp {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Study for exam", "Review notes and practice problems for upcoming test");
        Task task2 = new Task("Finish homework", "Math exercises, Science project");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);

        System.out.println("Initial To-Do List:");
        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Study for exam");

        System.out.println("\nTo-Do List after marking 'Study for exam' as completed:");
        toDoList.viewToDoList();
    }
}

class Task {
    private final String title;
    private final String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title \"" + title + "\" not found.");
    }

    public void viewToDoList() {
        Node current = head;
        if (current == null) {
            System.out.println("The to-do list is empty.");
            return;
        }

        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println("-----------");
            current = current.next;
        }
    }
}
