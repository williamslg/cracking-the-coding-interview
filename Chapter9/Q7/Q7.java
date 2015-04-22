import java.util.LinkedList;
public class Q7
{
    public static enum Color
    {
        Black, White, Red, Yellow, Green
    }
    
    public static class Point
    {
        int x;
        int y;
        public Point(int a, int b)
        {
            x = a;
            y = b;
        }
    }
    
    public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor)
    {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) return false;
        if (screen[y][x] == ocolor) {
            screen[y][x] = ncolor;
            paintFill(screen, x-1, y, ocolor, ncolor); // left
            paintFill(screen, x+1, y, ocolor, ncolor); // right
            paintFill(screen, x, y-1, ocolor, ncolor); // top
            paintFill(screen, x, y+1, ocolor, ncolor); // bottom
        }
        return true;
    }
    
    public static boolean paintFill(Color[][] screen, int x, int y, Color ncolor) {
        if (screen[y][x] == ncolor) return false;
        return paintFill(screen, x, y, screen[y][x], ncolor);
    }
    
    public static boolean paintFill1(Color[][] screen, int x, int y, Color ncolor) {
        if (screen[y][x] == ncolor) return false;
        //return paintFill(screen, x, y, screen[y][x], ncolor);
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        Color ocolor = screen[y][x];
        while (!queue.isEmpty()) {
            Point point = queue.remove();
            int i = point.y;
            int j = point.x;

                screen[i][j] = ncolor;
                insertQueue(screen, j-1, i, ocolor, queue); // left
                insertQueue(screen, j+1, i, ocolor, queue); // right
                insertQueue(screen, j, i-1, ocolor, queue); // top
                insertQueue(screen, j, i+1, ocolor, queue); // bottom

        }
        return true;
    }
    
    
    
    private static void insertQueue(Color[][] screen, int x, int y, Color ocolor, LinkedList<Point> queue)
    {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) return;
        //System.out.println("HERE!");
        if (screen[y][x] == ocolor) {
            //System.out.println("HERE!");
            queue.add(new Point(x, y));
        }
    }
    
    public static void main(String[] args)
    {
        Color[][] screen = {
            {Color.Red, Color.Green, Color.Green, Color.Black, Color.Yellow},
            {Color.Green, Color.Red, Color.Red, Color.Red, Color.Green},
            {Color.Green, Color.Red, Color.Red, Color.Red, Color.Green},
            {Color.Red, Color.Red, Color.Red, Color.Red, Color.Yellow},
            {Color.Red, Color.Yellow, Color.Red, Color.Black, Color.Yellow}
        };
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(screen[y][x] + "    ");
            }
            System.out.println();
        }
        paintFill1(screen, 2, 2, Color.Black);
        System.out.println();
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(screen[y][x] + "    ");
            }
            System.out.println();
        }
        
    }
}