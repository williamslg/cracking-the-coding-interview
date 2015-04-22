import java.util.Iterator;
public class CircularArray<Item> implements Iterable<Item>
{
    private Item[] s;
    private int head = 0;
    
    public CircularArray(int size)
    {
        s = (Item[]) new Object[size];
    }
    
    
    private int convert(int index)
    {
        if (index < 0) {
            index += s.length;
        }
        
        return (head + index) % s.length;
    }
    public void rotate(int shiftRight)
    {
        head = convert(shiftRight);
    }
    
    public Item get(int i) 
    {
        if (i < 0 || i >= s.length) {
            throw new java.lang.IndexOutOfBoundsException("...");
        }
        return s[convert(i)];
    }
    
    public void set(int i, Item item)
    {
        s[convert(i)] = item;
    }
    
    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }
    
    
    private class ArrayIterator implements Iterator<Item>
    {
        private int i = 0;
        
        public boolean hasNext() 
        {
            return i < s.length;
        }
        
        public void remove() {};
        public Item next()
        {
            return s[convert(i++)];
        }
    }
}