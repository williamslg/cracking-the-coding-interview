public class Solution
{
    public static int search(int[] a, int target)
    {
        return Bsearch(a, 0, a.length-1, target);
    }
    
    private static int Bsearch(int[] a, int low, int high, int target)
    {
        if (low > high) {
            return -1;
        }
        
        int mid = (low + high)/2;
        if (a[mid] == target) return mid;
        if (a[low] < a[mid]) { // left is sorted
            if (target <= a[mid] && target >= a[low]) {
                return Bsearch(a, low, mid-1, target);
            } else {
                return Bsearch(a, mid+1, high, target);
            }
        } else if (a[low] > a[mid]) { // right is sorted
            if (target >= a[mid] && target <= a[high]) {
                return Bsearch(a, mid+1, high, target);
            } else {
                return Bsearch(a, low, mid-1, target);
            }
        } else {
            if (a[mid] != a[high]) {
                return Bsearch(a, mid+1, high, target);
            } else {
                int result = Bsearch(a, low, mid-1, target);
                if (result == -1) {
                    result = Bsearch(a, mid+1, high, target);
                }
                return result;
            }
        }
        //return Math.max(Bsearch(a, low, mid-1, target), Bsearch(a, mid+1, high, target));
    }
    
    public static void main(String[] args)
    {
        int[] a = {3,1, 1};
        System.out.println(search(a, 3));
    }
}