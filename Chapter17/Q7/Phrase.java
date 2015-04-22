public class Phrase
{
    private static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] mid = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] bigs = {"", "Thousand", "Million", "Billion"};
    
    public static String English(int n)
    {
        if (n == 0) return "Zero";
        String str = "";
        if (n < 0) {
            str += "Negative ";
            n = -n;
        }
        
        int num = n / 1000000000;
        if (num != 0) {
            str = str + convert(num) + " Billion ";
        }
        
        num = (n / 1000000) % 1000;
        
        if (num != 0) {
            str = str + convert(num) + " Million ";
        }
        
        num = (n / 1000) % 1000;
        
        if (num != 0) {
            str = str + convert(num) + " Thousand ";
        }
        
        num = n % 1000;
        
        if (num != 0) {
            str = str + convert(num);
        }
        return str;
        
    }
    
    public static String convert(int n)
    {
        String str = "";
        
        int num = n / 100;
        if (num != 0) {
            str = str + digits[num-1] + " Hundred ";
        }
        n = n % 100;
        
        if (10 <= n && n <= 19) {
            str = str + mid[n-10];
        } else {
            if (n / 10 != 0) {
                str = str + tens[n/10 - 2] + " ";
            }
            if (n % 10 != 0) {
                str = str + digits[n%10 - 1];
            }
        }
        return str;
        
    }
    
    public static String numToString(int number)
    {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0) {
            return "Negative " + numToString(-1*number);
        }
        
        String str = "";
        int count = 0;
        while (number != 0) {
            if (number % 1000 != 0) {
                str = numToString100(number % 1000) + " " + bigs[count] + " " + str;
            }
            count++;
            number /= 1000;
        }
        
        return str;
    }
    
    public static String numToString100(int number)
    {
        String str = "";
        if (number >= 100) {
            str += digits[number/100 - 1] + " Hundred ";
            number = number % 100;
        }
        
        if (number >= 10 && number <= 19) {
            return str + mid[number - 10];
        }
        
        if (number >= 20) {
            str += tens[number/10 - 2] + " ";
            number = number % 10;
        }
        
        if (number > 0 && number < 10) {
            str += digits[number - 1];
        }
        return str;
        
    }
    
    public static void main(String[] args)
    {
        int n = 2000000;
        System.out.println(numToString(n));
    }
}