public class Q4
{
    public static int subtract(int a, int b)
    {
        return a + negate(b);
    }
    
    // get the negative number of a integer 
    private static int negate(int a)
    {
        int d = a < 0 ? 1 : -1;
        int neg = 0; //
        
        while (a != 0) { // use the fact if a + b = 0 => b = -a
            a += d; // keep adding 1 or -1
            neg += d; // neg to record its negative number
        }
        return neg;
    }
    
    private static int abs(int a)
    {
        if (a < 0) return negate(a);
        return a;
    }
    
    public static int multiply(int a, int b)
    {
        if (abs(a) < abs(b)) return multiply(b, a); // since b is the number of loops, so we can optimize it by using the smaller one
        
        int sum = 0;
        for (int i = 0; i < abs(b); i++) {
            sum += a;
        }
        
        if (b < 0) { // flip the result if b < 0
            sum = negate(sum); 
        }
        return sum;
    }
    

    
    public static int divide(int a, int b) throws java.lang.ArithmeticException// a/b
    {
       if (b == 0) throw new java.lang.ArithmeticException("/ by zero");
       int absA = abs(a);
       int absB = abs(b);
       
       int sum = 0;
       int k = 0;
       
       while (sum + absB <= absA) {
           sum += absB;
           k++;
       }
       //k--;
       if (a > 0 && b < 0 || a < 0 && b > 0) {
           k = negate(k);
       }
       return k;
    }
    
    public static void main(String[] args)
    {
        System.out.println(multiply(10, 5));
        System.out.println(subtract(0, -5));
        System.out.println(divide(2, 4) == (2/4));
    }
}