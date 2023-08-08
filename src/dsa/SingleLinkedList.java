package dsa;
public class SingleLinkedList {

    static Node head;
    int size;
    public static  class Node{
        int val;
        Node next;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
        public Node(int val){
            this.val = val;
        }
    }
    public SingleLinkedList (Node head){
        this.head = head;
    }
    public SingleLinkedList (){
    }


    public void printList() {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + "-> ");
            curr = curr.next;
        }
    }

    public Node add(int val){
        Node newNode = new Node(val,null);
        if(head==null){
            head = newNode;
            size++;
            return head;
        }else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
            size++;
            return head;
        }

    }

    public Node delete(int val){
        if (head.val == val) {
            head = head.next;
            size--;
            return head;
        }
        Node curr = head;
        while(curr.next!=null && curr != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
                size--;
            }else{
                curr = curr.next;
            }

        }
        return head;
    }

    public int size(){
        return this.size;
    }
    public Node add(int val, int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }else if(index==0){  //adding head
            Node temp1 = head;
            head = new Node(val);
            head.next = temp1;
            size++;
            return head;
        }else{
            Node curr = head;
            for(int i = 0; i < index-1; i++){
                curr = curr.next;
            }
            Node tmp = curr.next;
            curr.next = new Node(val);
            curr = curr.next;
            curr.next = tmp;
            return head;
        }
    }
    //get node from an index
    public Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    //delete node from an index
    public Node deleteFromIndex(int index){
        Node node = head;
        if(index==0){
            //remove head
        }else{
            //remove other
        }
    }
    /*
     * 1 -> 2 -> 3 -> 4
     *  */


    public static void main(String args []){
        SingleLinkedList list = new SingleLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(70,5);
        //list.delete(10);
        list.printList();
        System.out.println();
        System.out.println("List size " + list.size());
    }

}

