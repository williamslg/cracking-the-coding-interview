import java.util.Arrays;
public class Q6
{
    /*
     * My own version
     */
    public static void rotation(int[][] matrix)
    {
        if (matrix == null) return;
        int N = matrix.length;
        int x = 0, y = 0;
        
        while (N >= 2) {
            for (int i = 0; i < N-1; i++) {
                int tmp = matrix[x+i][y];
                matrix[x+i][y] = matrix[x+N-1][y+i];
                matrix[x+N-1][y+i] = matrix[x+N-1-i][y+N-1];
                matrix[x+N-1-i][y+N-1] = matrix[x][y+N-1-i];
                matrix[x][y+N-1-i] = tmp;
            }
            N -= 2;
            x++;
            y++;
        }
    }
    
    /*
     * CTCT version
     */
    public static void rotationLayer(int[][] matrix)
    {
        if (matrix == null) return;
        int N = matrix.length;
        for (int layer = 0; layer < N/2; layer++) { // Good design!!!
            int first = layer;
            int last = N - 1 - layer;
            
            for (int i = first; i < last; i++) {
                int offset = i - first; // Good design!!!
                int top = matrix[first][i];
                // left to top
                matrix[first][i] = matrix[last - offset][first];
                // bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right to bottom
                matrix[last][last - offset] = matrix[i][last];
                // top to right
                matrix[i][last] = top;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
        rotationLayer(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
    }
}