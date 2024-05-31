class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
     Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert a node at a specified position
    public void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < pos - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a node at a specified position
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        if (pos == 1) {
            head = temp.next;
            return;
        }

        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        Node next = temp.next.next;
        temp.next = next;
    }

    // Delete the node that occurs after a given node
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("The given node is null or has no next node");
            return;
        }

        prevNode.next = prevNode.next.next;
    }

    // Search for a node with a specific value
    public boolean searchNode(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack underflow");
            return -1;
        }

        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack
    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class LinkedListOperationsTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 2);

        System.out.println("Linked List after insertions:");
        list.display();

        list.deleteAtPosition(3);
        System.out.println("Linked List after deleting node at position 3:");
        list.display();

        Node secondNode = list.head.next; // Assuming the second node exists
        list.deleteAfterNode(secondNode);
        System.out.println("Linked List after deleting node after the second node:");
        list.display();

        System.out.println("Searching for node with value 20: " + list.searchNode(20));
        System.out.println("Searching for node with value 50: " + list.searchNode(50));

        Stack stack = new Stack();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Stack after push operations:");
        stack.display();

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Stack after pop operation:");
        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

