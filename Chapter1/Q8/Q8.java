public class Q8
{
    public static boolean isRotation(String s1, String s2)
    {
        if (s1 == null || s2 == null) return false;
        if (s1.length() == s2.length() && s1.length() != -1) {
            String s = s1 + s1;
            return s.indexOf(s2) >= 0;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        String s1 = "loveyoua";
        String s2 = "loveyoua";
        System.out.println(isRotation(s1, s2));
    }
}