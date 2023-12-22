import list.DoubleLinkedList;

public class Main {
    public static void main(String args []){
        DoubleLinkedList list = new DoubleLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.delete(40);
        //dsa.dsa.dsa.list.addNodeAtPosition(100, 0);
        //dsa.dsa.dsa.list.addNodeAtPosition(200, 4);
        list.printList();
        System.out.println();
        System.out.println("List size " + list.size());
    }
}
