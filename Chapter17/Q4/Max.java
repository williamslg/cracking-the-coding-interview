public class Max
{
    // This does not consider scenario of a - b overflow 
    public static int getMax(int a, int b)
    {
        int k = sign(a-b); 
        int q = flip(k);
        return a * k + b * q;
    }
    
    public static int flip(int a)
    {
        return 1 ^ a;
    }
    
    
    // return 1 if a positive and 0 if negative
    public static int sign(int a)
    {
        // >> will pad with the sign 
        return flip((a >> 31) & 0x1);
    }
    
    public static int max(int a, int b)
    {
        // overflow happens when a > 0, b < 0 or a < 0, b > 0;
        // In these two scenarios, we should set k = sign(a) when we return a * k + b * flop(k);
        // if a and b have the same sign, which will never overflow, we still need to use k = sign(a-b)
        int c = a - b;
        
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        
        // if sa == sb, k = sign(a-b), else k = sign(a)
        int t = sa ^ sb; // sa == sb, t = 0; else t = 1
        int k = sa * t + sc * flip(t);
        return a * k + b * flip(k);
    }
    
    
    
    
    
    public static void main(String[] args)
    {
        int a = Integer.MAX_VALUE - 1;
        int b = -10;
        System.out.println(getMax(a, b));
        System.out.println(max(a, b));
        System.out.println(sign(-1));
    }
}