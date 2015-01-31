import java.util.NoSuchElementException;
public class SortStack
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public SortStack()
    {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int item)
    {
        if (!stack1.isEmpty()) {
            if (stack1.peek() > item) {
                int tmp = stack1.pop();
                stack1.push(item);
                stack1.push(tmp);
            } else {
                stack1.push(item);
            }
        } else {
            stack1.push(item);
        }
    }
    
    public int pop()
    {
        if (stack1.isEmpty()) throw new NoSuchElementException();
        int item = stack1.pop();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            push(stack2.pop());
        }
        return item;
    }
    
    public static void main(String[] args)
    {
        SortStack stack = new SortStack();
        for (int i = 10; i > 0; i--) { //10-1
            stack.push(i);
        }
        
        for (int i = 0; i < 5; i++) { //10-6
            System.out.println(stack.pop());
        }
        
        for (int i = -5; i < 0; i++) {
            stack.push(i);
        }
        stack.push(100);
        for (int i = 0; i < 5; i++) { //10-6
            System.out.println(stack.pop());
        }
    }
    
}