public class Q5
{
    public static int getNumber(int a, int b)
    {
        int count = 0;
        //c = c & (c - 1) will clear the least significat bit(last 1)
        for (int c = a^b; c != 0; c = c & (c-1)) {
            count++;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        System.out.println(getNumber(1000, 112313));
    }
}