import java.util.Arrays;
public class Q3
{
    /*
     * By sorting the two strings and then compare the results
     */
    public static boolean isPermutation(String s1, String s2)
    {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        
        if (toChar(s1).equals(toChar(s2))) return true;
        else return false;
    }
    
    private static String toChar(String s)
    {
        if (s == null) return null;
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    public static boolean isPermutation2(String s1, String s2)
    {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (--count[s2.charAt(i)] < 0) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        String s1 = "evil";
        String s2 = "live";
        System.out.println(isPermutation2(s1, s2));
    }
}