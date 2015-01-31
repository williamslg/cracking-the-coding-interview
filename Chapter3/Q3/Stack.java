package Q2;
public class Stack
{
    private Node first;
    private int N;
    
    private class Node
    {
        private int item;
        private Node next;
    }
    
    public Stack()
    {
        first = null;
        N = 0;
    }
    
    public void push(int item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    
    public int pop()
    {
        int item = first.item;
        first = first.next;
        N--;
        return item;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public int peek()
    {
        return first.item;
    }
}