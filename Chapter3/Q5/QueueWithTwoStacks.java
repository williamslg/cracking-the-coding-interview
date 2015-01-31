import java.util.NoSuchElementException;
public class QueueWithTwoStacks<T>
{
    private Stack<T> stack1;
    private Stack<T> stack2;
    
    public QueueWithTwoStacks()
    {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    
    public void enqueue(T item)
    {
        stack1.push(item);
    }
    
    public T dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException();
        if (stack2.isEmpty()) move();
        return stack2.pop();
    }
    
    public boolean isEmpty()
    {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void move()
    {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public T peek()
    {
        if (isEmpty()) throw new NoSuchElementException();
        if (stack2.isEmpty()) move();
        return stack2.peek();
    }
    
    public int size()
    {
        return stack1.size() + stack2.size();
    }
    
    public static void main(String[] args)
    {
        QueueWithTwoStacks<String> q = new QueueWithTwoStacks<String>();
         while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
        
    }
}