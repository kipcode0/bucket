package list;

public class DoubleLinkedList {
     ListNode head;
    ListNode tail;

    private int size = 0;

    public DoubleLinkedList(){
        this.head = head;
        this.tail = tail;
    }

    public void addNode(int value){
        //at the beginning
        if(size==0){
            addNodeAtBeginning(value);
        }else{
            addNodeAtEnd(value);
        }

    }
    private void addNodeAtBeginning(int data) {
        ListNode newNode = new ListNode(data,null, null);
        if(head==null){
            head = newNode;
            tail = head;
            size++;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    private void addNodeAtEnd(int data){
        ListNode newNode = new ListNode(data,null,null);
        ListNode temp = tail;
        tail.next = newNode;
        newNode.prev = temp; //or newNode.prev = tail
        tail = newNode;
        size++;
    }

    public void addNodeAtPosition(int value, int index){
        if(index==0){
            addNodeAtBeginning(value);
        }else if(index==size){
            addNodeAtEnd(value);
        }else{
            //add at an index
            ListNode newNode = new ListNode(value, null, null);
            int j = 0;
            ListNode curr = head;
            while( j < index-1 && curr != null){
                curr = curr.next;
                j++;
            }
            if(curr==null){
                addNodeAtEnd(value);
            }
            //add node at index
            ListNode temp = curr.next;
            curr.next = newNode;
            newNode.prev = curr;
            newNode.next = temp;
            temp.prev = newNode;
            size++;
        }
    }

    public void delete(int data){
        if(head.value == data){
            ListNode temp = head.next;
            head = head.next;
            temp.prev = null;
            size--;
        }else if(tail.value == data){
            ListNode temp = tail.prev;
            tail = tail.prev;
            temp.next = null;
            size--;
        }else{
            //if not head or tail
            ListNode curr = head;
            while(curr != null && curr.value != data){
                curr = curr.next;
            }
            //curr==node
            ListNode temp = curr.prev;
            temp.next = curr.next;
            curr.next.prev = temp;
            size--;
        }
    }
    public int size(){
        return this.size;
    }

    public void printList(){
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.value + "->");
            curr = curr.next;
        }
    }


}


