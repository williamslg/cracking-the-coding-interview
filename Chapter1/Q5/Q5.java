public class Q5
{
    /*
     * Calculate the size of compressed string first and use StringBuilder to get the string;
     */
    public static String compress(String s)
    {
        if (s == null) return null;
        if (s.isEmpty()) return s;
        
        // Or add length check here
        int size = countSize(s);
        System.out.println(size);
        if (size >= s.length()) return s;
        
        StringBuilder result = new StringBuilder();
        char last = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                result.append(last);
                result.append(count);
                last = s.charAt(i);
                count = 1;
            }
        }
        
        result.append(last);
        result.append(count);
        String t = result.toString();
        if (t.length() < s.length()) return t;
        else return s;
    }
    
    private static int countSize(String s)
    {
        int count = 1;
        int size = 0;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                last = s.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
    
    public static String compressArray(String s)
    {
        if (s == null || s.isEmpty()) return s;
        int size = countSize(s);
        if (size >= s.length()) return s;
        
        char[] content = new char[size];
        char last = s.charAt(0);
        int count = 1;
        int index = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                index = setChar(content, last, count, index);
                last = s.charAt(i);
                count = 1;
            }
        }
       
        index = setChar(content, last, count, index);
        
        return String.valueOf(content);
    }
    
    private static int setChar(char[] content, char last, int count, int index)
    {
        content[index++] = last;
        char[] num = String.valueOf(count).toCharArray();
        for (char c : num) {
            content[index++] = c;
        }
        return index;
    }
    
    /* Use the StringBuilder to get the compressed string and check size before return;
    public static String compression(String s)
    {
        if (s == null) return null;
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            result.append(s.charAt(i));
            result.append(j-i);
            i = j;
        }
        String t = result.toString();
        if (t.length() < s.length()) return t;
        else return s;
    }
    */
    
    public static void main(String[] args)
    {
        String s = "abcccaasaaaaaaaaaaaaaaaaaa";
        System.out.println(compress(s));
        System.out.println(compressArray(s));
    }
}