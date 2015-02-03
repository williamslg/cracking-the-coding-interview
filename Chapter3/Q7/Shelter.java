//import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;
public class Shelter
{
    private LinkedList<Cat> cats;
    private LinkedList<Dog> dogs;
    private int timestamp;
    
    public Shelter()
    {
        cats = new LinkedList<Cat>();
        dogs = new LinkedList<Dog>();
        timestamp = 0;
    }
    
    public void enqueue(Animal obj)
    {
        obj.setNum(timestamp++);
        if (obj instanceof Cat) {
            cats.addLast((Cat)obj);
        } else if (obj instanceof Dog) {
            dogs.addLast((Dog)obj);
        }
    }
    
    public Animal dequeueAny()
    {
        if (isEmpty()) throw new NoSuchElementException();
        
        if (cats.size() == 0) {
            return dequeueDog();
        } else if (dogs.size() == 0) {
            return dequeueCat();
        } else {
            if (cats.peek().isOlderThan(dogs.peek())) {
                return dequeueCat();
            } else {
                return dequeueDog();
            }
        }
    }
    
    public Animal dequeueDog()
    {
        if (dogs.size() == 0) throw new NoSuchElementException();
        return dogs.poll();
    }
    
    public Animal dequeueCat()
    {
        if (cats.size() == 0) throw new NoSuchElementException();
        return cats.poll();
    }
    
    private boolean isEmpty()
    {
        return cats.isEmpty() && dogs.isEmpty();
    }
    
    public static void main(String[] args)
    {
        Shelter s = new Shelter();
        int n = 0;
        for (int i = 0; i < 10; i++)
        {
            s.enqueue(new Cat("Cat" + i));
            s.enqueue(new Dog("Dog" + i));
        }

        /*
        for (int i = 0; i < 3; i++) {
            System.out.println(s.dequeueDog().name);
        }
        
        System.out.println(s.dequeueAny().name);
        System.out.println(s.dequeueAny().name);
        System.out.println(s.dequeueAny().name);
        System.out.println(s.dequeueAny().name);
        System.out.println(s.dequeueAny().name);
        */
        
    }
}