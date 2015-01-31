import java.util.NoSuchElementException;
public class OldSetOfStacks
{
    private Node[] pointer;
    private Node first;
    private int N;
    private int stackSize;
    private int[] size;
    
    private class Node
    {
        private int item;
        private Node next;
    }
    
    public OldSetOfStacks(int Size)
    {
        if (Size <= 0) throw new IllegalArgumentException();
        stackSize = Size;
        pointer = new Node[10];
        size = new int[10];
        first = null;
        N = 0;
    }
    
    public void push(int item)
    {
        if (size[N] == stackSize) {
            pointer[N] = first;
            N++;
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size[N]++;
    }
    
    public int pop()
    {
        int index = N;
        while (index >=0 && size[index] == 0) {
            index--;
        }
        
        if (index < 0) throw new NoSuchElementException();
        if (index != N) {
            first = pointer[index];
        }
        int item = first.item;
        first = first.next;
        N = index;
        size[N]--;
        return item;
    }
    
    public int popAt(int index)
    {
        if (index < 0 || index > N) throw new IndexOutOfBoundsException();
        if (size[index] == 0) throw new NoSuchElementException();
        if (N == index) {
            int item = first.item;
            first = first.next;
            size[N]--;
            return item;
        } else {
            Node tmp = pointer[index];
            int item = tmp.item;
            pointer[index] = pointer[index].next;
            size[index]--;
            return item;
        }
    }
    
    public static void main(String[] args)
    {
        OldSetOfStacks stack = new OldSetOfStacks(3);
        stack.push(0);
         stack.push(0);
          stack.push(0);
           stack.push(1);
            stack.push(1);
             stack.push(1);
              stack.push(2);
               stack.push(2);
               //System.out.println(stack.pop());
               //System.out.println(stack.popAt(2));
               System.out.println(stack.popAt(2));
               System.out.println(stack.popAt(2));
               System.out.println(stack.popAt(1));
               System.out.println(stack.popAt(1));
               System.out.println(stack.popAt(1));
               System.out.println(stack.popAt(0));
               System.out.println(stack.popAt(0));
               System.out.println(stack.popAt(0));
               stack.push(0);
               System.out.println(stack.popAt(2));
               //System.out.println(stack.popAt(2));
               //System.out.println(stack.popAt(0));
               //System.out.println(stack.pop());
               //System.out.println(stack.pop());

    }
}