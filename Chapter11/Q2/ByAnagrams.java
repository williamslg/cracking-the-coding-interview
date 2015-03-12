import java.util.Arrays;
import java.util.Comparator;
public class ByAnagrams implements Comparator<String>
{
    public String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    public int compare(String v, String w)
    {
        return sortChars(v).compareTo(sortChars(w));
    }
}