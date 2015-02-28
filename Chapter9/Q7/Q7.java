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
    
    public static void main(String[] args)
    {
        Person[] A = new Person[6];
        A[0] = new Person(100, 10);
        A[1] = new Person(90, 10);
        A[2] = new Person(80, 11);
        A[3] = new Person(70, 10);
        A[4] = new Person(60, 14);
        A[5] = new Person(50, 13);
        ArrayList<Person> result = maxSeq(A);
        for (Person p: result) {
            System.out.print("(" + p.height + "," + p.weight + ") ");
        }
        System.out.println();
    }
}