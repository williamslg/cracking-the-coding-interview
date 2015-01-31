public class StackMin
{
    private int[] stack;
    private int[] min;
    private int N = 0;
    private int x = 0;
    private int Min;
    
    public StackMin(int N)
    {
        stack = new int[N];
        min = new int[N];
    }
    
    public void push(int item)
    {
        if (N == 0) {
            Min = item;
            min[x] = 0;
        }
        
        if (item < Min) {
            Min = item;
            min[++x] = N;
        }
        
        stack[N++] = item;
    }
    
    public int pop()
    {
        if (min[x] == N-1) {
            x--;
            Min = stack[min[x]];
        }
        
        int item = stack[--N];
        return item;
    }
    
    public int min()
    {
        return Min;
    }
    
    public static void main(String[] args)
    {
        StackMin stack = new StackMin(10);
        
        stack.push(0);
        System.out.println(stack.min()); //0
        stack.push(-2);
        stack.push(-3);
        stack.push(-2);
        stack.push(-4);
        System.out.println(stack.min()); //-4
        stack.pop();
        System.out.println(stack.min()); //-3
        stack.pop();
        System.out.println(stack.min());//-3
        stack.pop();
        System.out.println(stack.min());//-2
        stack.pop();
        System.out.println(stack.min());//0
    }
}