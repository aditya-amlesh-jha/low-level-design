package doublyLinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.insert(1, 10);
            linkedList.insert(2, 11);
            linkedList.insertAtHead(9);
            linkedList.insertAtTail(12);
            System.out.println(linkedList);
            linkedList.delete(2);
            linkedList.insert(1, 8);
            linkedList.delete(2);
            System.out.println(linkedList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
