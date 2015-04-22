import java.util.Random;
public class Ran7
{
    public static int ran7()
    {
        while (true) {
            int num = 5 * ran5() + ran5();
            if (num < 21) {
                return num % 7;
            }
        }
    }
    
    public static int ran5()
    {
        Random ran = new Random();
        return ran.nextInt(5);
    }
    
    public static void main(String[] args)
    {
        int[] count = new int[7];
        for (int i = 0; i < 140000; i++) {
            count[ran7()]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " : " + count[i]);
        }
    }
}