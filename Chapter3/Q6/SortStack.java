import java.util.NoSuchElementException;
import java.util.Random;
public class SortStack
{   
    public static void sort(Stack<Integer> stack1)
    {
        Stack<Integer> stack2 = new Stack<Integer>();
        while (!stack1.isEmpty()) {
            int target = stack1.pop();
            //int n = 0;
            while (!stack2.isEmpty() && stack2.peek() < target) {
                stack1.push(stack2.pop());
               // n++;
            }
            stack2.push(target);
            /*
            for (int i = 0; i < n; i++) {
                stack2.push(stack1.pop());
            }*/
        }
        
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            stack.push(random.nextInt(10));
        }

        
        sort(stack);
        for (int i = 0; i < 10; i++) { //10-6
            System.out.println(stack.pop());
        }

    }
    
}