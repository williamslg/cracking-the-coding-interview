import java.util.Random;
public class Partition
{
    public static Node partition(Node head, int x)
    {
        if (head == null) return null;
        
        Node first = null;
        Node last = null;
        
        while (head != null) {
            Node current = head;
            head = head.next;
            current.next = null;
            
            if (current.item < x) { // addFirst
                if (first == null) {
                    first = current;
                    last = current;
                } else {
                    current.next = first;
                    first = current;
                }
            } else {
                if (last == null) {
                    first = current;
                    last = current;
                } else {
                    last.next = current;
                    last = current;
                }
            }
        }
        return first;
    }
    
    public static void print(Node head)
    {
        while (head != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        Random random = new Random();
        Node first = new Node();
        first.item = 0;
        first.next = null;
        Node target = first;
        
        for (int i = 1; i < 10; i++) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        //System.out.println(DeleteNode.delete(first));
        Partition.print(first);
        Node head = Partition.partition(first, 1);
        Partition.print(head);
    }
}

class Node
{
    public int item;
    public Node next;
}