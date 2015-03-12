public class Q6
{
    // swap the odd and even bits of a
    public static int flipBits(int a)
    {
        // first get the odd and even bits by & with 0xaaaaaaaa and 0x55555555
        // Then >> odd, and << even,
        // Finally, | them
        return ((a & 0xaaaaaaaa) >> 1) | ( (a & 0x55555555) << 1);
        
    }
    
    public static void main(String[] args)
    {
        int a = 123;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(flipBits(a)));
    }
}