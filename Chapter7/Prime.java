import java.util.ArrayList;
public class Prime
{
    public static boolean isPrime(int n)
    {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static ArrayList<Integer> getPrimes(int max)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max < 0) return list;
        boolean[] flags = new boolean[max+1];
        
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
        
        int prime = 2;
        
        while (prime <= Math.sqrt(max)) {
            cutOff(flags, prime);
            prime = getNext(flags, prime);
            if (prime >= flags.length) break;
        }
        
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                list.add(i);
            }
        }
        return list;
    }
    
    private static void cutOff(boolean[] flags, int prime)
    {
        for (int i = prime*prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
    
    private static int getNext(boolean[] flags, int prime)
    {
        prime++;
        while (prime < flags.length && flags[prime] == false) {
            prime++;
        }
        return prime;
    }
    
    public static void main(String[] args)
    {
        System.out.println(isPrime(8));
        
        ArrayList<Integer> result = getPrimes(120);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}