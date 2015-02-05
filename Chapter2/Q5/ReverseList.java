public class ReverseList
{
    public static Node reverseList(Node head)
    {
        if (head == null) return null;
        
        Node prev = null;
        Node next = null;
        Node last = head;
        
        while (last != null) {
            next = last.next;
            last.next = prev;
            prev = last;
            last = next;
        }
        return prev;
    }
    
    public static void main(String[] args)
    {
        Node first = null;
        for (int i = 0; i < 1; i++) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        
        AddList.print(first);
        Node last = reverseList(first); 
        AddList.print(last);
    }
}