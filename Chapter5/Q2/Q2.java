public class Q2
{
    public static String toBinary(double x)
    {
        if (x >= 1 || x <= 0) return "ERROR";
        StringBuilder result = new StringBuilder();
        result.append(".");
       
        while (x > 0) {
            if (result.length() >= 32) {
                return "ERROR";
            }
            x = x*2;
            if (x >= 1.0) {
                result.append(1);
                x -= 1;
            } else {
                result.append(0);
            }
        }

         return result.toString();

    }
    
    public static void main(String[] args)
    {
        System.out.println(toBinary(0.72));
    }
}