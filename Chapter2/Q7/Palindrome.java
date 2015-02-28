public class Palindrome
{
    public static boolean isPalindrome(Node head)
    {
        // Create a reversed linked list and compare from the head one by one;
        // can be improved by adding a counter to get the length of the list and only compare the first n/2
         
        if (head == null) return false;
        Node current = head;
        Node first = null;
        int n = 0;
        while (current != null) {
            Node oldfirst = first;
            first = new Node();
            first.item = current.item;
            first.next = oldfirst;
            current = current.next;
            n++;
        }
        
        for (int i = 0; i < n/2; i++){
            if (first.item != head.item) return false;
            first = first.next;
            head = head.next;
        }
        return true;
      
    }
    
    public static boolean isPalindromeStack(Node head)
    {
        if (head == null) return false;
        
        Node T = head;
        Node H = head;
        
        Stack<Integer> stack = new Stack<Integer>();
        while (H != null && H.next != null) {
            stack.push(T.item);
            T = T.next;
            H = H.next.next;
        }
        
        if (H != null) {// odd number of nodes
            T = T.next;
        }
        
        while (T != null) {
            int value = stack.pop();
            if (value != T.item) return false;
            T = T.next;
        }
        return true;
        
    }
    
    public static boolean isPalindromeRecursive(Node head)
    {
        int length = getLength(head);
        Result result = isPalindromeHelper(head, length);
        return result.equal;
    }
    
    private static Result isPalindromeHelper(Node head, int length)
    {
        Result result = null;
        if (length == 0) {
            result = new Result();
            result.target = head;
        } else if (length == 1) {
            result = new Result();
            result.target = head.next;
        } else {
            result = isPalindromeHelper(head.next, length-2);
            if (result.equal) {
                if (head.item != result.target.item) {
                    result.equal = false;
                } else {
                    result.target = result.target.next;
                }
            }
        }
        return result;
    }
    
    private static int getLength(Node head)
    {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
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
        Node first = null;
        for (int i = 0; i < 3; i++) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        
        for (int i = 2; i > -1; i--) {
            Node oldfirst = first;
            first = new Node();
            first.item = i;
            first.next = oldfirst;
        }
        
        print(first);
        System.out.println(isPalindromeRecursive(first));
    }
}

class Node
{
    public int item;
    public Node next;
}

class Result
{
    public Node target = null;
    public boolean equal = true;
}