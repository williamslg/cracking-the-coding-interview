package Q2;
public class StackMin1
{
    private Stack s1, s2;
    
    public StackMin1()
    {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int item)
    {
        s1.push(item);
        if (item <= min())
            s2.push(item);
    }
    
    public int pop()
    {
        if (s1.peek() == min())
            s2.pop();
        return s1.pop();
    }
    
    public int min()
    {
        if (s2.isEmpty()) return Integer.MAX_VALUE;
        else return s2.peek();
    }
    
    public static void main(String[] args)
    {
        StackMin1 stack = new StackMin1();
        
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
        stack.push(0);
        System.out.println(stack.min());//0
    }
    
}