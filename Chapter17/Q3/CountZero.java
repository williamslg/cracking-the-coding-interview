public class CountZero
{
    public static int getNum(int n)
    {
        if (n < 0) return -1;
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
    
    public static int factorsOf5(int i)
    {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }
    
    public static int countZeros(int n)
    {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += factorsOf5(i);
        }
        return count;
    }
    
    public static int count(int n)
    {
        int count = 0;
        if (n < 0) return -1;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }
    
   public static int trailingZeroes(int n) { 
        if (n < 0) return 0; 
        int count = 0; 
        int factor = 5; 
        while (n/factor != 0) { 
            int num =  n / factor; 
            count += num;
            factor *= 5; 
        } 
        return count; 
    }
    
    
    public static void main(String[] args)
    {
        int n = 1808548329;
        System.out.println(getNum(n));
        System.out.println(countZeros(n));
        System.out.println(count(n));
        System.out.println(trailingZeroes(n));
    }
}
