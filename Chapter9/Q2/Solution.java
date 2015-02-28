import java.util.Arrays;
public class Solution
{
    public static void main(String[] args)
    {
        String[] strings = {"axyz", "abc", "yzax", "bac", "zyxa", "fg", "gf"};
        for(String s: strings)
        {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings, new ByAnagrams());
        for(String s: strings)
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
}