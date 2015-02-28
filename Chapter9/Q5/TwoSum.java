import java.util.HashMap;
public class TwoSum
{
    public static void solution (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int N = numbers.length;
        
        for (int i = 0; i < N; i++) {
            int value = target - numbers[i];
            if (map.containsKey(value)) {
                System.out.println(i + " " + map.get(value));
                return;
            }
            map.put(numbers[i], i);
        }
        /*
        for (int i = 0; i < N; i++) {
            if (map.containsKey(target - numbers[i]) && map.get(target-numbers[i]) != i) {
                System.out.println(i + " " + map.get(target-numbers[i]));
                return;
            }
        }
        */
        System.out.println("Can't find!");
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 5, 4, 6};
        solution(numbers, 10);
    }
}