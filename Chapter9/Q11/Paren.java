import java.util.ArrayList;
import java.util.HashMap;
public class Paren
{
   
    // !!!This method contains unknown bug!!!!
   
    /*
    public static ArrayList<String> getParen(String str, HashMap<String, Integer> map)
    {
        ArrayList<String> list = new ArrayList<String>();
        int n = str.length();
        //System.out.println(str);
        //System.out.println(n);
        if (n == 3) {
            list.add(str);
            
            if (!map.containsKey(str)) {
                int start = str.charAt(0) - '0';
                int end = str.charAt(2) - '0';
                if (str.charAt(1) == '|') {
                    map.put(str, start | end);
                } else if (str.charAt(1) == '&'){
                    map.put(str, start & end);
                } else if (str.charAt(1) == '^') {
                    map.put(str, start ^ end);
                }
            }
            return list;
        }
        
        
        
        
        ArrayList<String> right = getParen(str.substring(2), map);
        ArrayList<String> left = getParen(str.substring(0, n-2), map);
        
        for (String s : right) {
            String t = str.substring(0,2) + '(' + s + ')';
            if (!map.containsKey(t)) {
                int start = str.charAt(0) - '0';
                int end = map.get(s);
                if (str.charAt(1) == '|') {
                    map.put(t, start | end);
                } else if (str.charAt(1) == '&'){
                    map.put(t, start & end);
                } else if (str.charAt(1) == '^') {
                    map.put(t, start ^ end);
                }
            }
            list.add(t);
        }
        
        for (String s : left) {
            String t = '(' + s + ')' + str.substring(n-2);
            
            if (!map.containsKey(t)) {
                int start = str.charAt(n-1) - '0';
                int end = map.get(s);
                if (str.charAt(n-2) == '|') {
                    map.put(t, start | end);
                } else if (str.charAt(n-2) == '&'){
                    map.put(t, start & end);
                } else if (str.charAt(n-2) == '^') {
                    map.put(t, start ^ end);
                }
            }
            
            
            list.add(t);
        }
        
        
        //System.out.println("Second:" + n);
        if (n >= 7) {
        
        
        ArrayList<String> first = getParen(str.substring(0, 3), map);
        ArrayList<String> second = getParen(str.substring(4), map);
        
        for (String a : first) {
            for (String b : second) {
                String t = '(' + a + ')' + str.charAt(3) + '(' + b + ')';
                if (!map.containsKey(t)) {
                    int start = map.get(a);
                    int end = map.get(b);
                    if (str.charAt(3) == '|') {
                        map.put(t, start | end);
                    } else if (str.charAt(3) == '&'){
                        map.put(t, start & end);
                    } else if (str.charAt(3) == '^') {
                        map.put(t, start ^ end);
                    }
                }
                list.add(t);
            }   
        }
        
        if (n > 7) {
        first = getParen(str.substring(0, n-4), map);
        second = getParen(str.substring(n-3), map);
        
        for (String a : first) {
            for (String b : second) {
                String t = '(' + a + ')' + str.charAt(n-4) + '(' + b + ')';
                if (!map.containsKey(t)) {
                    int start = map.get(a);
                    int end = map.get(b);
                    if (str.charAt(n-4) == '|') {
                        map.put(t, start | end);
                    } else if (str.charAt(n-4) == '&'){
                        map.put(t, start & end);
                    } else if (str.charAt(n-4) == '^') {
                        map.put(t, start ^ end);
                    }
                }
                list.add(t);
            }   
        }
        }
        }
          
        return list;
    }
    
    public static ArrayList<String> getAll(String str, int target)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> list = getParen(str, map);
        ArrayList<String> result = new ArrayList<String>();
        for (String s : list) {
            if (map.get(s) == target) {
                result.add(s);
            }
        }
        return result;
    }
    
  */
    
    /*
     * pass a expression and desired boolean result, the starting index and ending index of the subexpression
     * get the number of ways to 
     */
    private static int getNum(String exp, boolean result, int low, int high, HashMap<String, Integer> map)
    {
        String key = "" + result + low + high; // key = true/flase + beginning index + ending index
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        // base case: single number
        if (low == high) { 
            if (exp.charAt(low) == '1' && result) return 1;
            if (exp.charAt(low) == '0' && !result) return 1;
            return 0;
        }
        
        int ways = 0;
        for (int i = low + 1; i <= high; i += 2) {
            char op = exp.charAt(i);
            if (result) { // True
                if (op == '|') {
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, true, i+1, high, map);
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high, map);
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, true, i+1, high, map);
                } else if (op == '&') {
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, true, i+1, high, map);
                   // ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high);
                    //ways += getNum(exp, false, low, i-1, map) * getNum(exp, true, i+1, high);
                } else if (op == '^') {
                    //ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high);
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high, map);
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, true, i+1, high, map);
                }
            } else { // Flase
                if (op == '|') {
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, false, i+1, high, map);
                    //ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high);
                    //ways += getNum(exp, false, low, i-1, map) * getNum(exp, true, i+1, high);
                } else if (op == '&') {
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, false, i+1, high, map);
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high, map);
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, true, i+1, high, map);
                } else if (op == '^') {
                    //ways += getNum(exp, true, low, i-1, map) * getNum(exp, false, i+1, high);
                    ways += getNum(exp, true, low, i-1, map) * getNum(exp, true, i+1, high, map);
                    ways += getNum(exp, false, low, i-1, map) * getNum(exp, false, i+1, high, map);
                }
            }
        }
        map.put(key, ways);
        return ways;
    }
    
    
    public static int getNum(String exp, boolean result)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return getNum(exp, result, 0, exp.length()-1, map);
    }
    
    public static void main(String[] args)
    {
        String s = "1^0|0|1|1|0|1|1";
        
        //String s = "1^0|0|1|1|0";
        System.out.println(getNum(s, false));
        
        //ArrayList<String> result = getAll(s, 0);
        /*
        for (String t : result) {
            System.out.println(t);
        }
        */
        //System.out.println(result.size());
    }
}