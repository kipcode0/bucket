package dsa;


import java.util.HashMap;
import java.util.Map;

/*
* Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

*LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
*int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
*If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*
*
*  */
public class LRUCache {
    Map<Integer, ListNode> map = new HashMap<>();
    int key;
    ListNode head;
    ListNode tail;

    int capacity;
    public LRUCache(int capacity){
        this.capacity= capacity;
        head = new ListNode(0,null,null); //sentinel
        tail = new ListNode(0,null,null); //sentinel
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode fetchedNode = map.get(key);
        //we need to move it to the back of Queue
        remove(fetchedNode);
        add(fetchedNode);
        return fetchedNode.value;
    }

    public void put(int key, int value){
        if(map.size() > capacity){
            //remove head.next (the head)
            map.remove(head.next.key);
            remove(head.next);
        }
        //inserting new node or updating existing key
        if(map.containsKey(key)){
            //delete the key
            ListNode temp = map.get(key);
            remove(temp);
            map.remove(key);
        }
        //create new node and add to the back
        ListNode newNode = new ListNode(key,null,null);
        newNode.value = value;
        add(newNode);
        map.put(key, newNode);
    }

    private void add(ListNode newNode){
        ListNode prevEnd = tail.prev;
        prevEnd.next = newNode;
        newNode.prev = prevEnd;
        newNode.next = tail;
        tail.prev = newNode;
    }

    public void remove(ListNode node){
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }

    public void printList(){
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = map.get(curr.key);
            if(temp != null){
                System.out.print(temp.value + "->");
            }
            curr = curr.next;
        }
    }

    public void printMap(){
        System.out.println(map.keySet());
    }

    public int size(){
        return map.size();
    }

}
