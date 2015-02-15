import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    
    private class Node
    {
        Item item;
        Node next;
        Node prev;
    }

   public Deque()                           
   {   }
   
   public boolean isEmpty()                 
   {
    return N == 0;
   }
   
   public int size()                        
   {
    return N;
   }
   
   public void addFirst(Item item)          
   {
    if (item == null)
        throw new java.lang.NullPointerException();
    
    if (!isEmpty())
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        oldFirst.prev = first;        
    }        
    else{
        first = new Node();
        first.item = item;
        last = first;
    }
    N++;
   }
   
   public void addLast(Item item)           
   {
    if (item == null)
        throw new java.lang.NullPointerException();
    
    if (!isEmpty())
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        oldLast.next = last;        
    }
    else
    {
        first = new Node();
        first.item = item;
        last = first;        
    }
    N++;
   }
   
   public Item removeFirst()                
   {
    if (isEmpty())
        throw new java.util.NoSuchElementException();
    
    Item item = first.item;
    first = first.next;
    if (first != null)
        first.prev = null;
    else
        last = null;
    N--;
    return item;    
   }
   
   public Item removeLast()                 
   {
    if (isEmpty())
        throw new java.util.NoSuchElementException();
    
    Item item = last.item;
    last = last.prev;
    if (last != null)
        last.next = null;
    else
        first = null;
    N--;
    return item;
   }
   
   public Iterator<Item> iterator()
   {
    return new DequeIterator();
   }
   
   private class DequeIterator implements Iterator<Item>
   {
    private Node current = first;
    public boolean hasNext()
    {
        return current != null;
    }
    public Item next()
    {
        if (current == null)
            throw new java.util.NoSuchElementException();
        
        Item item = current.item;
        current = current.next;
        return item;
    }
    public void remove()
    {
        throw new java.lang.UnsupportedOperationException();
    }
   }
   
   public static void main(String[] args)   
   {
    
   }
}