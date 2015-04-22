import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class Q6
{
    /*
     * This method uses the B-Tree to generate all the possible solutions
     * The key part is when to add ')' and when to terminate
     * We can add a ')' if the remaining '(' is less than ')', which means we have already placed more '('
     * We terminate when both remaining '(' and ')' are 0
     */
    public static ArrayList<String> getParen(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) return result;
        
        char[] list = new char[n*2];
        
        getParenHelper(result, list, n, n, 0);
        return result;
    }
    

    private static void getParenHelper(ArrayList<String> result, char[] list, int left, int right, int pos)
    {
        //System.out.println("left: " + left + " right: " + right);
        /*
        if (left < 0 || right < left)  {
            System.out.println("!!!!");
            return;
        }
        */
        if (left == 0 && right == 0) {
            result.add(new String(list));
            return;
        }
        
        
        // place '('
        if (left > 0) {
            list[pos] = '(';
            //left--;
            getParenHelper(result, list, left-1, right, pos+1);
        }
        
        if (right > left && right > 0) {
            list[pos] = ')';
            //right--;
            getParenHelper(result, list, left, right-1, pos+1);
        }
    }
    
    public static Set<String> generateParens(int remaining)
    {
        Set<String> set = new HashSet<String>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String s : prev) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        String str = insertParen(s, i);
                        set.add(str);
                    }
                }
                set.add("()" + s);
            }
        }
        return set;
    }
    
    private static String insertParen(String s, int i) 
    {
        String start = s.substring(0, i+1);
        String end = s.substring(i+1);
        return start + "()" + end;
    }
    
    public static void main(String[] args)
    {
        for (String s: generateParens(2)) {
            System.out.println(s);
        }
    }
}