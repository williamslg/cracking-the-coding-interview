import java.util.ArrayList;
public class NQueens
{
    public static ArrayList<String[]> solveNQueens(int n)
    {
        ArrayList<String[]> result = new ArrayList<String[]>();
        // columns[i]: indicate the queen is placed at (i, columns[i]); 
        int[] columns = new int[n];
        
        placeQueen(result, columns, 0, n);
        return result;
    }
    
    private static void placeQueen(ArrayList<String[]> result, int[] columns, int row, int n)
    {
        // base case, find a solution
        if (row == n) {
            String[] solution = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    
                    if (j == columns[i]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution[i] = sb.toString();
            }
            result.add(solution);
        }
        
        // keep adding find a valid position for current row
        for (int i = 0; i < n; i++) {
            if (isValid(columns, row, i)) {
                columns[row] = i; // save the column into the columns[]
                placeQueen(result, columns, row+1, n);
            }
        }
    }
    
    private static boolean isValid(int[] columns, int row, int col)
    {
        for (int i = 0; i < row; i++) {
            int y = columns[i]; // get the previous rows' column number
            if (y == col) return false;
            
            // check diagonal if (rowDistance == colDistance)
            int rowDistance = row - i;
            int colDistance = Math.abs(col - columns[i]);
            if (rowDistance == colDistance) return false;
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        int n = 8;
        ArrayList<String[]> result = solveNQueens(n);
        for (String[] solution : result) {
            for (int i = 0; i < solution.length; i++) {
                System.out.println(solution[i]);
            }
            System.out.println();
        }
    }
    
    
    
    /* Solution on CC
    public static ArrayList<Integer[]> solveNQueens(int n)
    {
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        
        if (n <= 0) return result;
        
        // columns[i]: one queen is placed on (i, columns[i]);
        Integer[] columns = new Integer[n];
        
        placeQueen(result, columns, 0, n);
        
        return result;
    }
    
    private static void placeQueen(ArrayList<Integer[]> result, Integer[] columns, int row, int n)
    {
        // find a solution
        if (row == n) {
            result.add(columns.clone());
        } else { // check each column at current row
            for (int i = 0; i < n; i++) {
                if (isValid(columns, row, i)) {
                    columns[row] = i;
                    placeQueen(result, columns, row+1, n);
                }
            }
        }
    }
    
    private static boolean isValid(Integer[] columns, int row, int col) {
        for (int i = 0; i < row; i++) {
            int y = columns[i];
            
            if (y == col) {
                return false;
            }
            
            int columnDistance = Math.abs(col - y);
            int rowDistance = row - i;
            
            if (rowDistance == columnDistance) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        for (Integer[] solution : solveNQueens(4)) {
            for (int i = 0; i < solution.length; i++) {
                System.out.print(solution[i] + " ");
            }
            System.out.println();
        }
    }
    */
    
}