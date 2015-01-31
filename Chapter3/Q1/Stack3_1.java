import java.util.NoSuchElementException;
public class Stack3_1<Item>
{
    //private int size = 900;
    private Node[] stack = new Node[900];
    private int[] pointer = {-1, -1, -1};
    private int[] size = {0, 0, 0};
    private int N = 0;
    
    private class Node<Item>
    {
        private Item item;
        private int previous;
    }
    
    public void push(int num, Item item)
    {
        stack[N] = new Node();
        stack[N].item = item;
        stack[N].previous = pointer[num];
        pointer[num] = N;
        while (stack[N] != null) {
            N++;
        }
        
    }
    
    public Item pop(int num)
    {
        if (isEmpty(num)) throw new NoSuchElementException("Stack " + num + " underflows!");
        int index = pointer[num];
        Item item = (Item)stack[index].item;
        pointer[num] = stack[index].previous;
        stack[index] = null;
        if (index < N) N = index;
        return item;
    }
    
    public Item peek(int num)
    {
        if (isEmpty(num)) throw new NoSuchElementException("Stack " + num + " underflows!");
        int index = pointer[num];
        Item item = (Item)stack[index].item;
        //pointer[num] = stack[index].previous;
        //stack[index] = null;
        return item;
    }
    
    public boolean isEmpty(int num)
    {
        return pointer[num] == -1;
    }
    
    public int getSize()
    {
        return N;
    }
    
    public void getStack()
    {
        for (int i = 0; i < 10; i++) {
            if (stack[i] != null) {
                System.out.println(stack[i].item);
            } else {
                System.out.println("null");
            }
        }
    }
    
        public static void main(String[] args)
    {
        Stack3_1<Integer> stack = new Stack3_1<Integer>();
        stack.push(2, 4); 
        System.out.println(stack.peek(2));  //4
        stack.pop(2);
        System.out.println("N: " + stack.getSize()); //0
        stack.push(0, 3); 
        stack.push(0, 7); 
        stack.push(0, 5); 
         stack.push(1, 5);
         stack.push(2, 4);
         stack.push(2, 4); 
                //System.out.println(stack.getSize(0));
        //System.out.println(stack.peek(0)); 
        System.out.println(stack.pop(0));  //5
        //System.out.println(stack.peek(0)); 
        System.out.println(stack.pop(0)); //7
        System.out.println(stack.pop(2)); //4
        stack.push(2, 4); 
        stack.push(2, 4); 
                System.out.println(stack.pop(2)); //
                        System.out.println(stack.pop(2)); //
                                System.out.println(stack.pop(2)); //
        System.out.println("N: " + stack.getSize()); //7 
        stack.getStack();

    }
    
}