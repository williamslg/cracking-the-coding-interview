public class KthToLast
{
    public static int recursive(Node first, int k) // Only print the value not return the reference
    {
        if (first == null) return 0;
        int n = 1 + recursive(first.next, k);
        if (n == k) System.out.println("Kth: " + first.item);
        return n;
    }
    
    public static Node reference(Node first, int k, IntWrapper i)
    {
        if (first == null) return null;
        Node result = reference(first.next, k, i);
        i.value++;
        if (i.value == k) return first;
        return result;
    }
    
    public static Node twoPointers(Node first, int k)
    {
        if (first == null || k <= 0) return null;
        Node T = first;
        Node H = first;
        
        for (int i = 0; i < k-1; i++) {
            if (H == null) return null;
            H = H.next;
        }
        
        if (H == null) return null;
        
        while (H.next != null) {
            H = H.next;
            T = T.next;
        }
        return T;
    }
    
    public static void main(String[] args) 
    {
        Node first = null;
        
        for (int i = 1; i > 0; i--) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        //System.out.println("Num: " +recursive(first, 1));
        IntWrapper i = new IntWrapper();
        Node kth = twoPointers(first, 1);
        System.out.println("Num: " + kth.item);
    }
}

class Node
{
    public int item;
    public Node next;
}

class IntWrapper
{
    public int value = 0;
}