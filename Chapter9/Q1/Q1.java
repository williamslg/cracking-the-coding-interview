public class Q1
{
    public static int numberWays(int n)
    {
        int num[] = new int[n+1];
        num[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            num[i] = helper(num, i-1) + helper(num, i-2) + helper(num, i-3);
        }
        return num[n];
    }
    
    private static int helper(int[] num, int n) {
        if (n < 0) return 0;
        else return num[n];
    }
    
    public static void main(String[] args)
    {
        System.out.println(numberWays(36));
    }
}