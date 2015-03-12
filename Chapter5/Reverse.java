import java.util.HashMap;
public class Reverse
{
    private HashMap<Byte, Integer> table = new HashMap<Byte, Integer>(); 
     
    public int reverseBits(int n) { 
        int result = 0; 
        for (int i = 0; i < 4; i++) { 
            result = result << 8; 
            
            byte bits = (byte) (n & 0xff); 
            System.out.println(Integer.toBinaryString(bits));
            Integer value = table.get(bits); 
            if (value != null) { 
                result |= value; 
            } else { 
                result |= getBits(bits); 
            } 
            n = n >>> 8; 
            
        } 
        return result; 
    } 
     
    private int getBits(byte bits) 
    { 
        //System.out.println(Integer.toBinaryString(bits));
        byte b = bits;
        int result = 0; 
        for (int i = 0; i < 8; i++) { 
            int bit = bits & 1; 
            result = (result << 1) | bit; 
            bits = (byte) (bits >>> 1); 
           // System.out.println(Integer.toBinaryString(result));
        } 
        table.put(b, result); 
        return result; 
    }
    
    public static void main(String[] args)
    {
        Reverse test = new Reverse();
        int n = 256;
        String s = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        System.out.println(s);
        s = String.format("%32s", Integer.toBinaryString(test.reverseBits(n))).replace(' ', '0');
        System.out.println(s);
        
        String str = "a   b c  d";
        String[] a = str.split(" ");
        for (String x: a) {
            System.out.println(x);
        }
        String sss  = " ";
        System.out.println(sss.length());
    }
}