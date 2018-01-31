/**
 * Created by jingxin on 8/22/17.
 */
public class LinkedListDeque<Item> {

    public class Node{
        public Item val;
        public Node next;
        public Node prev;
        public Node(Item x, Node n, Node p){
            val = x;
            next = n;
            prev = p;
        }
    }

    private Node sentinalNode;
    private int size;

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque(){
        sentinalNode = new Node(null, null, null);
        sentinalNode.next = sentinalNode;
        sentinalNode.prev = sentinalNode;
        size = 0;
    }

    /**
     * Adds an item to the front of the Deque
     */
    public void addFirst(Item x){
        Node nextNode = sentinalNode.next;
        sentinalNode.next = new Node(x, nextNode, sentinalNode);
        nextNode.prev = sentinalNode.next;
        size = size + 1;
    }

    /**
     * Adds an item to the back of the Deque
     */
    public void addLast(Item x){
        Node prevNode = sentinalNode.prev;
        prevNode.next = new Node(x, sentinalNode, prevNode);
        sentinalNode.prev = prevNode.next;
        size = size + 1;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    public boolean isEmpty(){
        if(size() == 0) return true;
        return false;
    }

    /**
     * Returns the number of items in the Deque
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the Deque from first to last, separated by a space
     */
    public void printDeque(){
        Node c = sentinalNode.next;
        while(c != sentinalNode){
            System.out.println(c.val);
            c = c.next;
        }
    }

    /**
     * Removes and returns the item at the front of the Deque. If no such item exists, return null.
     */
    public Item removeFirst(){
        Node front = sentinalNode.next;
        if(front != sentinalNode){
            sentinalNode.next = front.next;
            front.next.prev = sentinalNode;
            size = size - 1;
            return front.val;
        }
        return null;
    }

    /**
     * Removes and returns the item at the back of the Deque. If no such item exists, return null.
     */
    public Item removeLast(){
        Node back = sentinalNode.prev;
        if(back != sentinalNode){
            back.prev.next = sentinalNode;
            sentinalNode.prev = back.prev;
            size = size - 1;
            return back.val;
        }
        return null;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item
     * exists, return null. Must not alter the deque!
     */
    public Item get(int index){
        Node p = sentinalNode.next;
        while(p != sentinalNode && index >= 0){
            if(index == 0)  return p.val;
            p = p.next;
            index = index - 1;
        }
        return null;
    }

    /**
     * Same as get, but uses recursion
     */
    public Item helper(int index, Node start){
        if(start == sentinalNode)   return null;
        if(index == 0)  return start.val;
        return helper(index - 1, start.next);
    }
    public Item getRecursive(int index){
        Node p = sentinalNode.next;
        return helper(index, p);
    }
}
