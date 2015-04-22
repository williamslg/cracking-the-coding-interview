import java.util.ArrayList;
import java.util.Arrays;
public class Q7
{
    private static class Person implements Comparable<Person>
    {
        public int height;
        public int weight;
        
        public Person(int h, int w)
        {
            height = h;
            weight = w;
        }
        
        public int compareTo(Person that)
        {
            if (this.height != that.height) {
                return ((Integer)this.height).compareTo(that.height);
            } else {
                return ((Integer)this.weight).compareTo(that.weight);
            }
        }
        
        public boolean isLess(Person that) {
            if (this.height < that.height && this.weight < that.weight) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static ArrayList<Person> maxSeq(Person[] A)
    {
        if (A == null) return null;
        ArrayList<Person>[] solution = (ArrayList<Person>[])new ArrayList[A.length]; //unchecked cast warning
        //ArrayList<Person>[] solution = new ArrayList[A.length]; //this is from CTCI
        
        Arrays.sort(A);
        
        sequence(A, solution, 0);
        
        ArrayList<Person> result = solution[0];
        
        for (int i = 1; i < solution.length; i++) {
            if (solution[i].size() > result.size()) {
                result = solution[i];
            }
        }
        
        return result;
    }
    
    /*
     * This is a classic DP problem
     */
    private static void sequence(Person[] A, ArrayList<Person>[] solution, int index)
    {
        if (index >= A.length || index < 0) return;
        ArrayList<Person> longest = null;
        for (int i = 0; i < index; i++) {
            if (A[i].isLess(A[index])) {
                if (longest == null) {
                    longest = solution[i];
                } else {
                    longest = solution[i].size() > longest.size() ? solution[i] : longest;
                }
            }
        }
        solution[index] = new ArrayList<Person>();
        if (longest != null) {
            solution[index].addAll(longest);
        }
        solution[index].add(A[index]);
        sequence(A, solution, index+1);
    }
    
    
    
    /*
     * New version after learning DP, Don't have to save all the other list, only find the max number and building from the parent[]
     */
    public static ArrayList<Person> getMax(Person[] A)
    {
        ArrayList<Person> list = new ArrayList<Person>();
        if (A == null) return list;
        
        Arrays.sort(A);
        
        int[] num = new int[A.length]; // num[i] saves the max number of Longest Increasing Sequence ends at index i
        int[] parent = new int[A.length]; // parent[i] saves the previous element index of i
        
        int max = 0;
        int maxindex = 0;
        
        for (int i = 0; i < A.length; i++) {
            num[i] = 1;
            parent[i] = i;
            
            for (int j = 0; j <= i-1; j++) {
                if (A[j].isLess(A[i]) && num[j] + 1 > num[i]) {
                    num[i] = num[j] + 1;
                    parent[i] = j;
                }
            }
            if (num[i] > max) {
                max = num[i];
                maxindex = i;
            }
        }
        
        while (maxindex != parent[maxindex]) {
            list.add(0, A[maxindex]);
            maxindex = parent[maxindex];
        }
        list.add(0, A[maxindex]);
        return list;
    }
    
    public static void main(String[] args)
    {
        Person[] A = new Person[6];
        A[0] = new Person(65, 100);
        A[1] = new Person(70, 150);
        A[2] = new Person(56, 90);
        A[3] = new Person(75, 190);
        A[4] = new Person(60, 95);
        A[5] = new Person(68, 110);
        //ArrayList<Person> result = maxSeq(A);
        ArrayList<Person> result = getMax(A);
        for (Person p: result) {
            System.out.print("(" + p.height + "," + p.weight + ") ");
        }
        System.out.println();
    }
}