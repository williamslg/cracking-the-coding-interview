import java.util.NoSuchElementException;
public class Stack3<Item>
{
    private int size = 300;
    private Item[] stack = (Item[]) new Object[size * 3];
    private int[] pointer = {0, 0, 0};
    
    /*
    public Stack3(int N = 900)
    {
        stack = (Item[]) new Object[N];
        pointer = new int[3];
        pointer = {0, 0, 0};
        size = N / 3;
    }
    */
    
    public void push(int num, Item item)
    {
        if (num < 0 || num > 3) throw new IndexOutOfBoundsException();
        int index = num * size + pointer[num];
        stack[index] = item;
        pointer[num]++;
    }
    
    public Item pop(int num)
    {
        if (num < 0 || num > 3) throw new IndexOutOfBoundsException();
        if (isEmpty(num)) throw new NoSuchElementException("Stack " + num +" underflow!");
        int index = num*size + pointer[num] - 1;
        Item item = stack[index];
        stack[index] = null;
        pointer[num]--;
        return item;
    }
    
    public boolean isEmpty(int num)
    {
        return pointer[num] == 0;
    }
    
    public Item peek(int num)
    {
        if (num < 0 || num > 3) throw new IndexOutOfBoundsException();
        if (isEmpty(num)) throw new NoSuchElementException("Stack num underflow!");
        int index = num*size + pointer[num] - 1;
        Item item = stack[index];
        return item;
    }
    
    public int getSize(int num)
    {
        if (num < 0 || num > 3) throw new IndexOutOfBoundsException();
        return pointer[num];
    }
    
    public static void main(String[] args)
    {
        Stack3<Integer> stack = new Stack3<Integer>();
        stack.push(2, 4); 
        System.out.println(stack.peek(2)); 
        //stack.pop(2);
        stack.push(0, 3); 
        stack.push(0, 7); 
        stack.push(0, 5); 
         stack.push(1, 5); 
                System.out.println(stack.getSize(0));
        //System.out.println(stack.peek(0)); 
        System.out.println(stack.pop(0)); 
        //System.out.println(stack.peek(0)); 
        System.out.println(stack.pop(0)); 
        System.out.println(stack.pop(0)); 
        //System.out.println(stack.peek(0));  
        System.out.println(stack.getSize(0));
            System.out.println(stack.getSize(1));
                System.out.println(stack.getSize(2));
    }
}