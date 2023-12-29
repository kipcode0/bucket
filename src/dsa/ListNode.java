package dsa;

public class ListNode {
     int key;
     int value;
     ListNode next;
     ListNode prev;

    public ListNode(int key, ListNode next, ListNode prev){
        this.key = key;
        this.next = next;
        this.prev = prev;
    }

}
