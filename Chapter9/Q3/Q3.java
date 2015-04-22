public class Q3
{
    /*
     * The key part is : 
     * 1. sorted distinct array, so it must be increasing.
     * 2. A[low] <= low, if A[low] > low which means all the A[low..high] will be greater than their index
     * 3. A[high] >= high, if A[high] < high which means all the A[low..high] will less than their index
     */
    public static int findMagic(int[] A)
    {
        if (A == null) return -1;
        return findMagicDup(A, 0, A.length - 1);
    }
    
    private static int findMagic(int[] A, int low, int high)
    {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (A[mid] == mid) {
            return mid;
        } else if (A[mid] < mid) { // it only can locate at right since 2.
            return findMagic(A, mid+1, high);
        } else { // it only can locate at left since 3.
            return findMagic(A, low, mid-1);
        }
    }
    
    private static int findMagicDup(int[] A, int low, int high)
    {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (A[mid] == mid) {
            return mid;
        } 
        
        // search left by Math.min(mid-1, A[mid]);
        // search right by Math.max(mid + 1, A[mid]);
        
        int left = Math.min(mid-1, A[mid]);
        int result = findMagicDup(A, low, left);
        if (result != -1) return result;
        
        
        int right = Math.max(mid+1, A[mid]);
        return findMagicDup(A, right, high);
        /*
        else if (A[mid] < mid) {
            int result = findMagicDup(A, mid+1, high);
            if (result == -1) {
                result = findMagicDup(A, low, A[mid]);
            }
            return result;
        } else {
            int result = findMagicDup(A, low, mid-1);
            if (result == -1) {
                result = findMagicDup(A, A[mid], high);
            }
            return result;
        }
        */
    }
    
    
    
    public static void main(String[] args)
    {
        int[] A = {-1, -1, 1, 3, 4};
        
        System.out.println(findMagic(A));
    }
    
    
}