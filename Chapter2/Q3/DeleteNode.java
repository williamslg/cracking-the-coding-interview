public class DeleteNode
{
    public static boolean delete(Node target)
    {
        if (target == null || target.next == null) return false;
        target.item = target.next.item;
        target.next = target.next.next;
        return true;
    }
    
    public static void print(Node first)
    {
        while (first != null) {
            System.out.print(first.item +" ");
            first = first.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
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
        System.out.println(DeleteNode.delete(first));
        DeleteNode.print(first);
    }
}

class Node {
    public int item;
    public Node next;
}