import java.util.ArrayList;
import java.util.Collections;
public class Q5
{
    // 1. use a list as a stack to save one permutation
    public static ArrayList<String> permutation(String str)
    {
        ArrayList<String> result = new ArrayList<String>();
        
        if (str == null || str.isEmpty()) return result;
        
        ArrayList<Character> list = new ArrayList<Character>();
        helper(result, list, str, 0);
        return result;
    }
    
    // use a list to store the permutation, iterate the string characters keep inserting them into spots 
    private static void helper(ArrayList<String>result, ArrayList<Character> list, String str, int pos)
    {
        if (pos == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c: list) {
                sb.append(c);
            }
            result.add(sb.toString());
            //System.out.println("*****" + sb.toString());
            return;
        }
        
        for (int i = 0; i <= list.size(); i++) { // for a character at pos, there are list.size() + 1 spots to insert
            list.add(i, str.charAt(pos));
            helper(result, list, str, pos+1);
            list.remove(i);
        }
    }
    
    // 2. Recursion thinking, solve a big problem from a small problems
    
    public static ArrayList<String> getPerm(String str, int pos)
    {
        ArrayList<String> list = new ArrayList<String>();
        if (pos == str.length() - 1) {
            list.add(str.charAt(pos) + "");
            return list;
        }
        
        ArrayList<String> subList = getPerm(str, pos + 1);
        for (String s: subList) {
            for (int i = 0; i <= s.length(); i++) {
                String result = insertChar(s, str.charAt(pos), i);
                list.add(result);
            }
        }
        return list;
    }
    
    private static String insertChar(String s, char c, int pos)
    {
        String start = s.substring(0, pos);
        String end = s.substring(pos);
        return start + c + end;
    }
    
    public static void main(String[] args)
    {
        String str = "123";
        //ArrayList<String> result = permutation(str);
        ArrayList<String> result = getPerm(str, 0);
        Collections.sort(result);
        System.out.println(result.size());
        for (String s: result) {
            System.out.println(s);
        }
    }
}