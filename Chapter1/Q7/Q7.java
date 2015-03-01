import java.util.Arrays;
public class Q7
{
    /* Use two boolean arrays to record the row and column that should be set to zero
     * O(M*N) time complexity and O(M+N) space complexity
     */
    public static void setZero(int[][] matrix)
    {
        if (matrix == null) return;
        int M = matrix.length;
        int N = matrix[0].length;
        
        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (row[i]) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 0; j < N; j++) {
            if (col[j]) {
                for (int i = 0; i < M; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    
    /*
     * O(M*N) time complexity and O(1) space complexity
     * Same concept as the first one but use the 1st row and 1st column to record 0 columns and rows
     */
    public static void zero(int[][] matrix)
    {
        if (matrix == null) return;
        int M = matrix.length;
        int N = matrix[0].length;
        
        boolean row = false;
        boolean col = false;
        
        // check the 1st column to see if it should be set to 0 later
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }
        // check the 1st row to see if it should be set to 0 later
        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                row = true;
                break;
            }
        }
        
        // go through the rest of the matrix and set corresponding column and row 0 if encounter a 0
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // like the way in first method, go through the 1st row and column and set 0
        for (int i = 1; i < M; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < M; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < M; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Finally set 1st row and column to 0 if they are
        if (row) {
            for (int j = 0; j < N; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (col) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{0, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
        zero(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
    }
}