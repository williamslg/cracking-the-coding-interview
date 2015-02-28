public class Q4
{
    public static String replace(char[] content, int length)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (content[i] != ' ') {
                result.append(content[i]);
            } else {
                result.append("%20");
            }
        }
        return result.toString();
    }
    
    public static void replace2(char[] content, int length)
    {
        int spacecount = 0;
        for (int i = 0; i < length; i++) {
            if (content[i] == ' ') {
                spacecount++;
            }
        }
        
        int newlength = length + spacecount*2;
        content[newlength] = '\0';// This is not legal!!!
        for (int i = length - 1; i >= 0; i--) {
            if (content[i] == ' ') {
                content[--newlength] = '0';
                content[--newlength] = '2';
                content[--newlength] = '%';
            } else {
                content[--newlength] = content[i];
            }
        }
    }
    
    public static void main(String[] args)
    {
        String content = "I love you            ";
        char[] test = content.toCharArray();
        System.out.println(test);
        replace2(test, 10);
        System.out.println(test);
        //System.out.println(replace(content.toCharArray(), 10));
    }
}