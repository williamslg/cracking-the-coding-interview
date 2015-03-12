public class Q3
{
    /*
     * My own implementation to get the smallest number that has same 1s and is greater than num
     */
    public static void nextBinary(int num)
    {
        if (num <= 0) return;
        int x = num;
        int i = 0;
        int pre = -1;
        int min = -1;
        int max = -1;
        int count = 0;
        while (x > 0) {
            x = num >> i;
            System.out.println(i + " " +Integer.toBinaryString(x));
            int bit = x & 1;
            if (min == -1 && bit == 0 && pre == 1) { //get the first 0 that with 1 on its right
                min = num | (1 << i); // flip the 0 to 1
                min = min & (~0 << (i-1)); // clear all the bits on its right
                min = min | ((1 << count-1) - 1); // add (count - 1) 1s to the right most
            }
            pre = bit;
            count += bit;
            i++;
        }
        max = ((1 << count) - 1) << (31 - count);
        System.out.println(Integer.toBinaryString(min));
        System.out.println(Integer.toBinaryString(max));
    }
    
    public static int getNext(int num)
    {
        if (num <= 0) return -1;
        // find the position of first 0 what with 1 on its right
        int c0 = 0;
        int c1 = 0;
        int c = num;
        
        while (((c & 1) == 0) && c > 0) { //count the number of trailing 0s
            c0++;
            c = c >> 1;
        }
        
        while ((c & 1) == 1) { //count the number of 1s until reach a 0
            c1++;
            c = c >> 1;
        }
        
        // Error checking! make sure the last 0 won't appear at the 32th which will exceed the Integer.MAX_VALUE;
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        
        int p = c0 + c1;
        num = num | (1 << p); // flip the right most 0
        num = num & (~0 << p); // clear the right p bits
        num = num | ((1 << (c1 - 1)) - 1); // add c1 -1 1s at the rightmost
        return num;
    }
    
    public static int getPrev(int num)
    {
        if (num <= 0) return -1;
        
        int c = num;
        int c0 = 0;
        int c1 = 0;
        
        while ((c & 1) == 1) {
            c1++;
            c = c >> 1;
        }
        
        if (c == 0) return -1; // 00000111, numbers like this can't find the value;
        
        while ((c & 1) == 0 && c > 0) {
            c0++;
            c = c >> 1;
        }
        
        int p = c0 + c1;
        num = num & (~0 << (p+1)); // clear bits from 0 to p;
        
        int a = (1 << (c1 + 1)) -1; // c1 + 1 1s
        int b = a << (c0 - 1); // left shift c0 - 1 0s
        return num | b;
        
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(13948));
        System.out.println(Integer.toBinaryString(getNext(13948)));
        System.out.println(Integer.toBinaryString(getPrev(13948)));
    }
}