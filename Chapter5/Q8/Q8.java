public class Q8
{
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y)
    {
        if (x1 > x2) return;
        int start = width / 8 * y + x1/8;
        int startOffset = x1 % 8;
        
        int end = width / 8 * y + x2/8;
        int endOffset = x2 % 8;
        
        /*
        if (startOffset != 0) { // means the screen[start] is not fully set
            start++;
        }
        if (endOffset != 7) { // means the screen[end] is not fully set
            end--;
        }
        */
        
        for (int i = start+1; i < end; i++) { // set fully set bytes
            screen[i] = (byte) 0xff;
            
        }
        
        byte startMask = (byte) (0xff >> startOffset); // offset is 0-7 start from the left 
        byte endMask = (byte) ~(0xff >> (endOffset + 1));
        // deally with the start and end 
        if (x1/8 == x2/8) { // in the same byte
            byte mask = (byte) (startMask & endMask);
            screen[start] |= mask;
        } else {
            if (startOffset == 0) {
                screen[start] = (byte)0xff;
            } else {
                screen[start] |= startMask;
            }
            
            if (endOffset == 7) {
                screen[end] = (byte)0xff;
            } else {
                screen[end] |= endMask;
            }
        } 
    }
    
    public static void main(String[] args)
    {
        byte[] screen = new byte[16];
        for (byte i: screen) {
            String s = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(s);
        }
        drawLine(screen, 32, 0 , 31, 0);
        for (byte i: screen) {
            System.out.println(i);
            String s = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(s);
        }
    }
}