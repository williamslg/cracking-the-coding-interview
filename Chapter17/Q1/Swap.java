public class Swap
{
    //reverse two numbers in place
    public static void swap(int a, int b)
    {
        a = b - a;
        b = b - a;
        a = a + b;
        
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }
    
    
    public static void swapXor(int a, int b)
    {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }
    
    
    public static void main(String[] args)
    {
        int a = 10;
        int b = -9;
        swapXor(a, b);
    }
}