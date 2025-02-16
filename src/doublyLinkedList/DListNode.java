package doublyLinkedList;

public class DListNode {
    public DListNode prev;
    public DListNode next;
    public int val;

    public DListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}
