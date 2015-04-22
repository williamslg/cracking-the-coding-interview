import java.util.Stack;
import java.util.LinkedList;
import java.util.HashMap;
public class Q2
{
    int[][] available;
    private static class Point
    {
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public Q2(int[][] free)
    {
        int n = free.length;
        int m = free[0].length;
        available = new int[n][m];
        
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                available[i][j] = free[i][j];
            }
        }
    }
    
    public boolean getPath(int x, int y, LinkedList<Point> path, HashMap<Point, Boolean> cache)
    {
        Point p = new Point(x, y);
        //path.add(p);
        if (cache.containsKey(p)) {
            return cache.get(p);
        }
        
        if (x == 0 && y == 0) {
            path.add(p);
            return true;
        }
        
        boolean success = false;
        if (x > 0 && isFree(x-1, y)) {
            success = getPath(x-1, y, path, cache);
        }
        
        if (!success && y > 0 && isFree(x, y-1)) {
            success = getPath(x, y - 1, path, cache);
        }
        
        if (success) {
            path.add(p);
        }
        cache.put(p, success);
        return success;
    }
    
    
    public LinkedList<LinkedList<Point>> getAllPaths(int x, int y)
    {
        LinkedList<LinkedList<Point>> lists = new LinkedList<LinkedList<Point>>();
        Stack<Point> stack = new Stack<Point>();
        getAllPaths(0, 0, x, y, lists, stack);
        return lists;
    }
    
    private void getAllPaths(int i, int j, int x, int y, LinkedList<LinkedList<Point>> lists, Stack<Point> stack)
    {
        if (!isFree(i, j)) return;
        Point p = new Point(i, j);
        stack.push(p);
        if (i == x && j == y) {
            LinkedList<Point> list = new LinkedList<Point>();
            list.addAll(stack);
            lists.add(list);
        } else {
            getAllPaths(i+1, j, x, y, lists, stack);
            getAllPaths(i, j+1, x, y, lists, stack);
        }
        stack.pop();
    }
    
    private boolean isFree(int x, int y)
    {
        if (x < 0 || y < 0 || x >= available.length || y >= available[0].length) return false;
        return available[x][y] == 1;
    }
    
    /*
     * Number of ways to get to (x, y) from (0, 0)
     */
    public static int numberWays(int x, int y)
    {
        int[][] board = new int[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = board[i-1][j] + board[i][j-1];
                }
            }
        }
        return board[x][y];
    }
    
    
    /*
     * If there are some apples on the road, the max number of apples we can get and print out the path
     */
    
    public static int maxApples(int[][] apple)
    {
        int M = apple.length;
        int N = apple[0].length;
        int[][] num = new int[M][N]; // 2D array to get the max number
        
        //Queue<Point> path = new LinkedList<Point>();
        num[0][0] = apple[0][0];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                num[i][j] = apple[i][j] + Math.max(getAppleHelper(i-1, j, num), getAppleHelper(i, j-1, num));
            }
        }
        
        Stack<Point> stack = new Stack<Point>();
        getApplePaths(M-1, N-1, num, apple, stack);
        
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            System.out.print("(" + p.x + ", " + p.y + ") ");
        }
        return num[M-1][N-1];
    }
    
    private static int getAppleHelper(int x, int y, int[][] num)
    {
        if (x < 0 || y < 0) {
            return -1;
        } else {
            return num[x][y];
        }
    }
    
    // get from 
    
    private static void getApplePaths(int x, int y, int[][] num, int[][] apple, Stack<Point> stack)
    {
        stack.push(new Point(x, y));
        if (x == 0 && y == 0) return;
        
        if (x > 0 && num[x][y] == apple[x][y] + num[x-1][y]) {
            getApplePaths(x-1, y, num, apple, stack);
        } else if (y > 0 && num[x][y] == apple[x][y] + num[x][y-1]){
            getApplePaths(x, y-1, num, apple, stack);
        }
    }
    
        
        
    
    
    private static int helper(int x, int y, int[][] board)
    {
        if (x < 0 || y < 0) return 0;
        else return board[x][y];
    }
    
    public static void main(String[] args)
    {
        //System.out.println(numberWays(4,3));
        int[][] free= {{1, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 1}};
        Q2 test = new Q2(free);
        //Stack<Point> stack = new Stack<Point>();
        LinkedList<Point> path = new LinkedList<Point>();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
        test.getPath(2, 3, path, cache);
        
        
        for (Point p : path) {
            //Point p = path.remove();
            System.out.print("(" + p.x + ", " + p.y + ") ");
        }
        System.out.println("******");
        
        
        LinkedList<LinkedList<Point>> lists = test.getAllPaths(2, 3);
        for (LinkedList<Point> list : lists) {
            for (Point p: list) {
                System.out.print("(" + p.x + ", " + p.y + ") ");
            }
            System.out.println();
        }
        
        
        
        
        // get max number of apples
        /* 
         * 0012
         * 0201
         * 0001
         * 0001
         */
       
        
        int[][] apples = {{0, 0, 1, 2}, {0, 2, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        System.out.println(maxApples(apples));
    }
}