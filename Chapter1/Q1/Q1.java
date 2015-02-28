import java.util.HashMap;
public class Q1
{
    /*
     * HashMap version O(n) space and O(n) time complexity
     */
    public static boolean isUnique(String s)
    {
        if (s == null || s.equals("")) return true;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) return false;
            map.put(s.charAt(i), 1);
        }
        return true;
    }
    
    /*
     * Index counting version O(n) space and O(n) time complexity
     */
    public static boolean isUnique2(String s)
    {
        if (s == null || s.equals("")) return true;
        int N = s.length();
        if (N > 256) return false;
        
        boolean[] count = new boolean[256];
        for (int i = 0; i < N; i++) {
            if (count[s.charAt(i)]) return false;
            count[s.charAt(i)] = true;
        }
        return true;
    }
    
    /*
     * brute force version O(n^2)
     */
    public static boolean BruteForce(String s)
    {
        if (s == null || s.equals("")) return true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) return false;
            }
        }
        return true;
    }
    
    /*
     * int[8] use bit version
     */
    public static boolean Bit(String s)
    {
        if (s == null || s.equals("")) return true;
        int N = s.length();
        if (N > 256) return false;
        
        int[] count = new int[8];
        for (int i = 0; i < N; i++) {
            int value = s.charAt(i);
            int index = value / 32;
            int pos = value % 32;
            if ((count[index] & (1 << pos)) > 0) return false;
            count[index] |= (1 << pos);
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        String s = "xyz*!^~~";
        
        System.out.println(isUnique(s));
        System.out.println(isUnique2(s));
        System.out.println(BruteForce(s));
        System.out.println(Bit(s));
    }
        
}