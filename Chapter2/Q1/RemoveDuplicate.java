import java.util.Hashtable;
public class RemoveDuplicate
{
    public static void hashRemove(Node first) // O(n)
    {
        Node previous = first;
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        while (first != null) {
            if (table.containsKey(first.item)) {
                previous.next = first.next;
            } else {
                table.put(first.item, true);
                previous = first;
            }
            first = first.next;
        }
    }
    
    public static void goRemove(Node first) // O(n*n)
    {
        while (first != null) {
            Node current = first.next;
            Node previous = first;
            while (current != null) {
                if (current.item == first.item) {
                    previous.next = current.next;
                } else {
                    previous = current;
                }
                current = current.next;
            }
            first = first.next;
        }
    }
    
    public static void main(String[] args)
    {
        Node first = new Node();
        first.item = 0;
        for (int i = 1; i < 5; i++) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        
        for (int i = 0; i < 5; i++) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        //first = sort(first);
        goRemove(first);
        while (first != null) {
            System.out.println(first.item);
            first = first.next;
        }

    }
}

class Node
{
    int item;
    Node next;
}

