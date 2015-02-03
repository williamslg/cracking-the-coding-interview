import java.util.Hashtable;
class RemoveDuplicate
{
    public static void remove(Node first)
    {
        Node previous = first;
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        while (first != null) {
            if (table.containsKey(first.item)) {
                previous.next = first.next;
            } else {
                table.put(first.item, true);
                previous = first;
            }
            first = first.next;
        }
    }
}

class Node
{
    int item;
    Node next;
}