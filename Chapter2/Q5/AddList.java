public class AddList
{
     /*  My own solution
      *  input :7->1->6, 5->9->2
      *  output: 2->1->9
      */
    public static Node addNumber(Node head1, Node head2)
    {
        Node first = null;
        Node last = null;
        int n = 0;
        int digit, num;
        while (head1 != null || head2 != null || n != 0) { 
            num = n;
            if (head1 != null) {
                num += head1.item;
                head1 = head1.next;
            }
            if (head2 != null) {
                num += head2.item;
                head2 = head2.next;
            } 
            
            digit = num % 10;
            n = num / 10;
            
            if (first == null) {
                first = new Node();
                first.item = digit;
                last = first;
            } else {
                Node current = new Node();
                current.item = digit;
                last.next = current;
                last = current;
            }
        }
        
        return first;
    }
    
    /*
     *  input :6->1->7, 2->9->5
     *  output: 9->1->2
     *  1. reverse two lists
     *  2. call reverse list addition
     *  3. reverse the result from step 2
     */
    public static Node addReverse(Node head1, Node head2) // my forward list solution
    {
        Node last1 = reverseList(head1);
        Node last2 = reverseList(head2);
        
        Node result = addNumber(last1, last2);
        return reverseList(result);
    }
    
    /*
     * reverse a list given its head and return the last (new head)
     */
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
    
    /*
     * Print the list
     */
    public static void print(Node head) 
    {
        while (head != null) {
            System.out.print(head.item + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    /*
     * Recursive version on the CTCI
     */
    public static Node recursiveAdd(Node head1, Node head2, int carry)
    {
        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }
        Node current = new Node();
        Node next1 = null;
        Node next2 = null;
        int digit = carry;
        if (head1 != null) {
            digit += head1.item;
        }
        if (head2 != null) {
            digit += head2.item;
        }
        current.item = digit % 10;
        carry = digit / 10;
        if (head1!= null) {
            next1 = head1.next;
        }
        if (head2!= null) {
            next2 = head2.next;
        }
        Node result = recursiveAdd(next1, next2, carry);
        current.next = result;
        
        return current;
    }
    
    public static void main(String[] args)
    {
        Node first = new Node();
        first.item = 6;
        Node oldfirst = first;
        first = new Node();
        first.item = 1;
        first.next = oldfirst;
        
        oldfirst = first;
        first = new Node();
        first.item = 7;
        first.next = oldfirst;
        
        Node first2 = new Node();
        first2.item = 3;
        Node oldfirst2 = first2;

      
        first2 = new Node();
        first2.item = 9;
        first2.next = oldfirst2;
        
        oldfirst2 = first2;
        first2 = new Node();
        first2.item = 5;
        first2.next = oldfirst2;
 
        
        AddList.print(first);
        AddList.print(first2);
        
        //Node head = AddList.addNumber(first, first2);
        //AddList.print(head);
        Node head = AddList.recursiveAdd(first, first2, 0);
        AddList.print(head);
    }
}

class Node
{
    public int item;
    public Node next;
}