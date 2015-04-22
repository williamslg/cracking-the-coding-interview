import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
public class TallestStack
{
    public static class Box implements Comparable<Box>
    {
        public int height;
        public int width;
        public int depth;
        
        public Box(int h, int w, int d)
        {
            height = h;
            width = w;
            depth = d;
        }
        
        // sort based on width, break tie by depth and height
        public int compareTo(Box that)
        {
            if (this.width != that.width) {
                return ((Integer)(this.width)).compareTo(that.width);
            } else {
                if (this.depth != that.depth) {
                    return ((Integer)(this.depth)).compareTo(that.depth);
                } else {
                    return ((Integer)(this.height)).compareTo(that.height);
                }
            }
        }
        
        public boolean isLess(Box that) {
            if (this.width < that.width && this.depth < that.depth && this.height < that.height) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static ArrayList<Box> getMax(Box[] A)
    {
        ArrayList<Box> result = new ArrayList<Box>();
        
        if (A == null || A.length == 0) return result;
        
        Arrays.sort(A);
        
        int[] height = new int[A.length];
        int[] parent = new int[A.length];
        int max = 0;
        int maxindex = 0;
        
        for (int i = 0; i < A.length; i++) {
            height[i] = A[i].height;
            parent[i] = i;
            for (int j = 0; j < i; j++) {
                if (A[j].isLess(A[i])) {
                    height[i] += height[j];
                    parent[i] = j;
                }
            }
            if (max < height[i]) {
                max = height[i];
                maxindex = i;
            }
        }
        
        int p = maxindex;
        while (p != parent[p]) {
            result.add(A[p]);
            p = parent[p];
        }
        result.add(A[p]);
        return result;
    }
    
    
    public static ArrayList<Box> getStack(Box[] A)
    {
        if (A == null || A.length == 0) return null;
        
        ArrayList<Box> max = null;
        int max_height = 0;
        HashMap<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>();
        for (int i = 0; i < A.length; i++) {
            ArrayList<Box> top = getStack(A, A[i], map);
            int top_height = getHeight(top);
            if (max_height < top_height) {
                max = top;
                max_height = top_height;
            } 
        }
        return max;
    }
    
    private static ArrayList<Box> getStack(Box[] A, Box bottom, HashMap<Box, ArrayList<Box>> map)
    {
        if (map.containsKey(bottom)) {
            return map.get(bottom);
        }
        ArrayList<Box> max = null;
        int max_height = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i].isLess(bottom)) {
                ArrayList<Box> top = getStack(A, A[i], map);
                int top_height = getHeight(top);
                if (max_height < top_height) {
                    max = top;
                    max_height = top_height;
                } 
            }
        }
        if (max == null) {
            max = new ArrayList<Box>();
        } else {
            max = (ArrayList<Box>)max.clone();
        }
        max.add(0, bottom);
        map.put(bottom, max);
        return max;
    }
    
    private static int getHeight(ArrayList<Box> stack)
    {
        int sum = 0;
        for (Box b : stack) {
            sum += b.height;
        }
        return sum;
    }
    
    
    public static void main(String[] args)
    {
        Box[] A = new Box[7];
        A[0] = new Box(3, 6, 5);
        A[1] = new Box(4, 8, 6);
        A[2] = new Box(3, 9, 2);
        A[3] = new Box(4, 8, 7);
        A[4] = new Box(5, 6, 10);
        A[5] = new Box(9, 7, 9);
        A[6] = new Box(10, 6, 9);   
        
        ArrayList<Box> result = getMax(A);
        for (Box box : result) {
            System.out.println("(" + box.height + ", " + box.width + ", " + box.depth + ")");
        }
        
        ArrayList<Box> result1 = getStack(A);
        for (Box box : result1) {
            System.out.println("(" + box.height + ", " + box.width + ", " + box.depth + ")");
        }
        
    }
}