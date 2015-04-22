public class Q8
{
    public static int getNum(int n, int c)
    {
        int num = 0;
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n >= 25 && c >= 25) {
            num += getNum(n-25, 25);
        }
        if (n >= 10 && c >= 10) {
            num += getNum(n-10, 10);
        }
        if (n >= 5 && c >= 5) {
            num += getNum(n-5, 5);
        }
        if (n >= 1 && c >= 1) {
            num += getNum(n-1, 1);
        }
        return num;
    }
    
    public static int getNum2(int sum, int c, int n)
    {
        if (sum > n) return 0;
        if (sum == n) return 1;
        
        int ways = 0;
        
        if (c == 25) {
            ways += getNum2(sum + 25, 25, n);
        }
        if (c >= 10) {
            ways += getNum2(sum + 10, 10, n);
        }
        if (c >= 5) {
            ways += getNum2(sum + 5, 5, n);
        }
        if (c >= 1) {
            ways += getNum2(sum + 1, 1, n);
        }
        return ways;
    }
    
    public static int getNum3(int n, int[] cent, int pos)
    {
        if (pos == cent.length - 1) return 1;
        int ways = 0;
        for (int i = 0; i * cent[pos] <= n; i++) {
            ways += getNum3(n-i*cent[pos], cent, pos+1);
        }
        return ways;
    }
    
    public static int makeChange(int n)
    {
        int[] cent = {25, 10, 5, 1};
        int[][] map = new int[n+1][cent.length];
        return getNum4(n, cent, 0, map);
    }
    
    public static int getNum4(int n, int[] cent, int pos, int[][] map)
    {
        if (map[n][pos] > 0) {
            System.out.println(n + " : " + pos + " : " + map[n][pos]);
            return map[n][pos];
        }
        if (pos == cent.length - 1) return 1;
        int ways = 0;
        for (int i = 0; i * cent[pos] <= n; i++) {
            ways += getNum4(n-i*cent[pos], cent, pos+1, map);
        }
        map[n][pos] = ways;
        return ways;
    }
    
    public static void main(String[] args)
    {
        int[] cent = {25, 10, 5, 1};
        int n = 1000;
        System.out.println(getNum(n, 25));
        System.out.println(getNum2(0, 25, n));
        System.out.println(getNum3(n, cent, 0));
        System.out.println(makeChange(n));
    }
}