public class Q1
{
    public static int mergeBits(int n, int m, int i, int j)
    {
        // i = 2, j = 6
        // Create a mask like 10000011, 0s from j to i
        int ones = ~0; // create all 1s 11111111
        int left = ones << (j+1); // clear bits from j to 0, which means keep 1s after j (exclusive) 10000000;
        int right = (1 << i) - 1; // create 00000100 first, minus 1 generates 00000011
        int mask = left | right; // 10000011; clear bits from j to i;
        
        int nCleard = n & mask; // generate x00000xx;
        int mShifted = m << i; // generate  0xxxxx00;
        
        return nCleard | mShifted;
    }
    
    public static void main(String[] args)
    {
                
        
        
        
        
        
                //System.out.println();
        int N = 1 << 10;
        System.out.println("N:" + Integer.toBinaryString(N));
        int M = Integer.parseInt("10011", 2);
        
        System.out.println(Integer.toBinaryString(mergeBits(N, M, 2, 6)));
    }
    
}