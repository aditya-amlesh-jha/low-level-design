package doublyLinkedList;

public class LinkedList {
    private DListNode head;
    private DListNode tail;
    private int currSize;

    public LinkedList(){
        head = new DListNode(-1);
        tail = new DListNode(-1);

        head.next = tail;
        tail.prev = head;

        currSize = 0;
    }

    public void insert(int pos, int val) throws Exception {
        DListNode newNode = new DListNode(val);
        DListNode currNode = getNodeAtPos(pos);
        DListNode prevNode = currNode.prev;

        newNode.prev = prevNode;
        prevNode.next = newNode;
        newNode.next = currNode;
        currNode.prev = newNode;

        currSize += 1;
    }

    public void insertAtHead(int val){
        DListNode newNode = new DListNode(val);
        DListNode nextNode = head.next;
        newNode.prev = head;
        head.next = newNode;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        currSize += 1;
    }

    public void insertAtTail(int val){
        DListNode newNode = new DListNode(val);
        DListNode prevNode = tail.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        tail.prev = newNode;
        newNode.next = tail;

        currSize += 1;
    }

    private void deleteNode(DListNode currNode) throws Exception {
        if(currNode == null || currNode == head || currNode == tail){
            throw new Exception("No Nodes to delete");
        }

        DListNode prevNode = currNode.prev;
        DListNode nextNode = currNode.next;

        currNode.next = null;
        currNode.prev = null;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void delete(int pos) throws Exception {
        DListNode currNode = getNodeAtPos(pos);
        deleteNode(currNode);

        currSize -= 1;
    }

    public void deleteAtHead() throws Exception {
        deleteNode(head.next);
        currSize -= 1;
    }

    public void deleteAtTail() throws Exception {
        deleteNode(tail.prev);
        currSize -= 1;
    }

    public int getCurrSize() {
        return currSize;
    }

    private DListNode getNodeAtPos(int pos) throws Exception {
        if(!(pos == currSize + 1) && (pos > currSize || pos <= 0)){
            throw new Exception("Position should be within [1,"+currSize+"]");
        }

        DListNode currNode = head.next;

        for(int i=1;i<pos;i++){
            currNode = currNode.next;
        }

        return currNode;
    }

    private String printList(){
        DListNode currNode = head.next;
        StringBuilder listOutput = new StringBuilder();

        while(currNode.next != null){
            listOutput.append(currNode.val).append(" <-> ");
            currNode = currNode.next;
        }

        return listOutput.toString();
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "currSize=" + currSize +
                "\n" +
                "list= [ " + printList() + " ]" +
                "\n" +
                '}';
    }
}
