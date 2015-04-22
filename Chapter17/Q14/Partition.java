import java.util.HashMap;
public class Partition
{
    private HashMap<String, Integer> dict;
    
    private class Result
    {
        public int invalid;
        public String parsed;
        
        public Result(int inv, String p) {
            invalid = inv;
            parsed = p;
        }
    }
    
    public Partition(String[] book)
    {
        dict = new HashMap<String, Integer>();
        for (int i = 0; i < book.length; i++) {
            dict.put(book[i], 1);
        }
            
    }
    
    public String seperate(String words) {
        HashMap<Integer, Result> cache = new HashMap<Integer, Result>();
        Result result = OPT(words, 0, cache);
        return result.parsed;
    }
    
    public Result OPT(String words, int start, HashMap<Integer, Result> cache)
    {
        if (cache.containsKey(start)) {
            System.out.println("Cache:" + start);
            return cache.get(start);
        }
        if (start >= words.length()) {
            return new Result(0, "");
        }
        
        int min = Integer.MAX_VALUE;
        String str = "";
        for (int i = start; i < words.length(); i++) {

            String p = words.substring(start, i+1);
            int val = match(p);
            if (val != 0) {
                p = p.toUpperCase();
            }
            
            Result res = OPT(words, i+1, cache);
            
            p += " " + res.parsed;
            
            val += res.invalid;
            
            if (min > val) {
                min = val;
                str = p;
            }
        }
        
        Result result = new Result(min, str);
        cache.put(start, result);
        return result;
    }
    
    public int match(String word)
    {
        if (dict.containsKey(word)) {
            return 0;
        } else {
            return word.length();
        }
    }
    
    /*
    public int seperate(String words)
    {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return OPT(words, 0, cache);
    }
    
    public int OPT(String words, int start, HashMap<Integer, Integer> cache)
    {
        if (cache.containsKey(start)) {
            //System.out.println("Cache:" + start);
            return cache.get(start);
        }
        
        if (start >= words.length()) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = start; i < words.length(); i++) {
            int val = match(words.substring(start, i+1)) + OPT(words, i+1, cache);
            if (min > val) {
                min = val;
            }
        }
        
        cache.put(start, min);
        return min;
    }
    
    public int match(String word)
    {
        if (dict.containsKey(word)) {
            return 0;
        } else {
            return word.length();
        }
    }
    */
    public static void main(String[] args)
    {
        String[] dict = {"this", "is", "awesome",  "a", "we", "some", "i", "his", "so", "me", "an"};
        Partition test = new Partition(dict);
        System.out.println(test.seperate("zhangisawesome"));
    }
}