import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
public class Q7
{
    public static void add(Queue<Integer> queue, int x)
    {
        queue.add(3*x);
        queue.add(5*x);
        queue.add(7*x);
    }
    
    public static int removeMin(Queue<Integer> queue)
    {
        int min = queue.peek();
        for (int x : queue) {
            if (x < min) {
                min = x;
            }
        }
        
        while (queue.contains(min)) {
            queue.remove(min);
        }
        return min;
    }
    
    public static int getKth(int k)
    {
        if (k < 0) return 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int val = 1;
        add(queue, val);
        
        for (int i = 0; i < k; i++) {
            val = removeMin(queue);
            add(queue, val);
        }
        return val;
    }
    
    public static int getKthNumber(int k)
    {
        if (k < 0) return 0;
        
        int val = 1;
        Queue<Integer> queue3 = new LinkedList<Integer>();
        Queue<Integer> queue5 = new LinkedList<Integer>();
        Queue<Integer> queue7 = new LinkedList<Integer>();
        
        queue3.add(1);
        
        for (int i = 0; i <= k; i++) {
            int v3 = queue3.isEmpty() ? Integer.MAX_VALUE : queue3.peek();
            int v5 = queue5.isEmpty() ? Integer.MAX_VALUE : queue5.peek();
            int v7 = queue7.isEmpty() ? Integer.MAX_VALUE : queue7.peek();
            val = Math.min(v3, Math.min(v5, v7));
            
            if (val == v3) {
                queue3.remove();
                queue3.add(3*val);
                queue5.add(5*val);
                queue7.add(7*val);
            } else if (val == v5) {
                queue5.remove();
                queue5.add(5*val);
                queue7.add(7*val);
            } else {
                queue7.remove();
                queue7.add(7*val);
            }
        }
        return val;
    }
    
    public static void main(String[] args)
    {
        /*
        for (int i = 0; i < 13; i++) {
            System.out.println(getKthNumber(i));
        }
        */
        double a = 0.0 / -1.0;
        double b = 0.0 / 1;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        if (map.containsKey(a)) {
            map.put(a, map.get(a) + 1);
        } else {
            map.put(a, 1);
        }
        
        if (map.containsKey(b)) {
            map.put(b, map.get(b) + 1);
        } else {
            map.put(b, 1);
        }
        
        for (Double test : map.keySet()) {
            System.out.println(test + " " + map.get(test));
        }
    }
}