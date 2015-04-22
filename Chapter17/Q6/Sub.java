public class Sub
{
    public static class Result
    {
        public int m = 0;
        public int n = 0;
        
        public String toString() 
        {
            return "(" + m + ", " + n + ")";
        }
    }
    
    public static Result findSub(int[] A)
    {
        if (A == null) return null;
        
        Result res = new Result();
        int N = A.length;
        int left = 0;
        int right = N - 1;
        
        // find the increasing part on the left or until left = N - 1 
        while (left < N - 1 && A[left] <= A[left + 1]) {
            left++;
        }
        
        // find the decreasing part on the right or until right = 0;
        while (right > 0 && A[right] >= A[right - 1]) {
            right--;
        }
        
        if (left < right) {
            int min = A[right];
            int max = A[left];
            
            for (int i = left + 1; i < right - 1; i++) {
                if (A[i] > max) {
                    max = A[i];
                }
                if (A[i] < min) {
                    min = A[i];
                }
            }
            
            // A[left] <= min || left = -1
            while (left >= 0 && A[left] > min) {
                left--;
            }
            
            // A[right] > max || right = A.length
            while (right <= A.length - 1 && A[right] < max) {
                right++;
            }
            res.m = left + 1;
            res.n = right - 1;
        } else {
            res.m = 0;
            res.n = 0;
        }
        return res;
    }
    
    private static int findLeft(int[] A)
    {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) return i-1;
        }
        return A.length - 1;
    }
    
    private static int findRight(int[] A)
    {
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i+1]) return i+1;
        }
        return 0;
    }
    
    private static int shrinkLeft(int[] A, int min, int start)
    {
        for (int i = start - 1; i >= 0; i--) {
            if (A[i] <= A[min]) return i + 1;
        }
        return 0;
    }
    
    private static int shrinkRight(int[] A, int max, int start)
    {
        for (int i = start; i <= A.length - 1; i++) {
            if (A[i] >= A[max]) return i - 1;
        }
        return A.length - 1;
    }
    
    public static void findSeq(int[] A)
    {
        if (A == null || A.length <= 1) return;
        int left = findLeft(A);
        int right = findRight(A);
        
        int min = left + 1;
        if (min >= A.length) return;
        int max = right - 1;
        
        for (int i = left; i <= right; i++) {
            if (A[min] > A[i]) min = i;
            if (A[max] < A[i]) max = i;
        }
        
        int m = shrinkLeft(A, min, left);
        int n = shrinkRight(A, max, right);
        
        System.out.println("(" + m + ", " + n + ")");
    }
    
    
    public static void main(String[] args)
    {
        //int[] A = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] A = {1, 2, 4, -1, 2};
        Result res = findSub(A);
        System.out.println(res.toString());
        findSeq(A);
    }
}