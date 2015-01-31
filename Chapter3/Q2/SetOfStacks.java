import java.util.NoSuchElementException;
public class SetOfStacks
{
    private Stack[] stacks;
    private int N;
    private int stacksize;
    
    private class Stack
    {
        private int[] buf;
        private int N;
        
        public Stack(int capacity)
        {
            if (capacity <= 0) throw new IllegalArgumentException();
            buf = new int[capacity];
            N = 0;
        }
        
        public void push(int item)
        {
            buf[N++] = item;
        }
        
        public int pop()
        {
            if (isEmpty()) throw new NoSuchElementException();
            return buf[--N];
        }
        
        public boolean isEmpty()
        {
            return N == 0;
        }
        
        public boolean isFull()
        {
            return N == buf.length;
        }
    }
    
    public SetOfStacks(int num, int capacity)
    {
        if (num <= 0 || capacity <= 0) throw new IllegalArgumentException();
        stacks = new Stack[num];
        stacksize = capacity;
        stacks[0] = new Stack(capacity);
    }
    
    public void push(int item)
    {
        if (stacks[N].isFull()) {
            N++;
            stacks[N] = new Stack(stacksize);
        }
        stacks[N].push(item);
    }
    
    public int pop()
    {
        while (N >= 0 && stacks[N].isEmpty()) {
            stacks[N] = null;
            N--;
        }
        if (N < 0) throw new NoSuchElementException();
        return stacks[N].pop();
    }
    
    public int popAt(int index)
    {
        if (index < 0 || index > N) throw new IndexOutOfBoundsException();
        if (stacks[index].isEmpty()) throw new NoSuchElementException();
        return stacks[index].pop();
    }
    
    public boolean isEmpty()
    {
        while (N >=0 && stacks[N].isEmpty()) {
            N--;
        }
        if (N < 0) return true;
        else return false;
    }
    
    public boolean isFull()
    {
        if (N == stacks.length-1) return stacks[N].isFull();
        else return false;
    }
    
    public static void main(String[] args)
    {
        SetOfStacks stack = new SetOfStacks(10, 100);
        for(int i = 0; i < 3*100+1; i++){
            stack.push(i);
        }
        
        for(int i = 0; i < 100; i++){
            stack.popAt(0);
            //ss1.popAt(1);
            stack.popAt(2);
        }
        
        stack.popAt(3);
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}