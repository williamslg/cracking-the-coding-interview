/* Add two numbers represented by linked list 
 * 1->2->3 normal order
 */

public class AddNumber
{
    /*
     * Wrapper class in order to return the Node and carry at the same time
     */
    private class Wrapper
    {
        public Node sum = null;
        public int carry = 0;
    }
    
    /*
     * return the length of a list
     */
    private static int getLength(Node head)
    {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
    
    /*
     * Add 0 padding in front of the list
     */
    private static Node padding(Node head, int n)
    {
        if (head == null) return null;
        for (int i = 0; i < n; i++) {
            Node current = new Node();
            current.item = 0;
            current.next = head;
            head = current;
        }
        return head;
    }
    
    /*
     * Recursive helper function
     */
    
    private Wrapper addNumberHelper(Node head1, Node head2)
    {
        if (head1 == null && head2 == null) {
            return new Wrapper(); // return carry = 0 and null at the same time;
        }
        Wrapper result = addNumberHelper(head1.next, head2.next);
        int digit = result.carry + head1.item + head2.item;
        result.carry = digit/10;
        Node current = new Node();
        current.item = digit % 10;
        current.next = result.sum;
        result.sum = current;
        
        return result;
    }
    
    public Node addNumber(Node head1, Node head2)
    {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        
        if (len1 < len2) {
            head1 = padding(head1, len2-len1);
        } else if (len1 > len2){
            head2 = padding(head2, len1-len2);
        }
        
        Wrapper result = addNumberHelper(head1, head2);
        if (result.carry != 0) {
            Node head = new Node();
            head.item = result.carry;
            head.next = result.sum;
            return head;
        }
        
        return result.sum;
    }
    
        public static void main(String[] args)
    {
        Node first = new Node();
        first.item = 9;
        Node oldfirst = first;
        first = new Node();
        first.item = 9;
        first.next = oldfirst;
        
        oldfirst = first;
        first = new Node();
        first.item = 9;
        first.next = oldfirst;
        
        Node first2 = new Node();
        first2.item = 9;
        Node oldfirst2 = first2;

      /*
        first2 = new Node();
        first2.item = 9;
        first2.next = oldfirst2;
        
        oldfirst2 = first2;
        first2 = new Node();
        first2.item = 9;
        first2.next = oldfirst2;
 */
        
        AddList.print(first);
        AddList.print(first2);
        
        //Node head = AddList.addNumber(first, first2);
        //AddList.print(head);
        AddNumber test = new AddNumber();
        Node head = test.addNumber(first, first2);
        AddList.print(head);
    }
    
}