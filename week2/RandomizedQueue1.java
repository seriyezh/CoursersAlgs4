import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;    
    private int N;
    
    private class Node
    {
        Item item;
        Node next;        
    }

   public RandomizedQueue()                           
   {   }
   
   public boolean isEmpty() { return N == 0; }
   
   public int size() { return N; }
   
   public void enqueue(Item item)
   {
       if (item == null) throw new java.lang.NullPointerException();
       
       Node oldFirst = first;
       first = new Node();
       first.item = item;
       first.next = oldFirst;
       N++;
   }
   
   public Item dequeue()
   {
       if (isEmpty()) throw new java.util.NoSuchElementException();
       
       int index = StdRandom.uniform(N);
       
       int i = 0;
       Node node = first;
       while (i < index)
       {
           node = node.next;
           i++;
       }
       
       
   }
   
   public Item sample()
   {
       if (isEmpty()) throw new java.util.NoSuchElementException();
       
       
   }
   
   private class RandomIterator implements Iterator<Item>
   {
       private int i = a.length;
       private Item[] rand;
       
       public RandomIterator()
       {
           Item[] temp = a;
           StdRandom.shuffle(temp);
           rand = temp;
       }
       
       public boolean hasNext() { return i > 0;  }
       public Item next() 
       { 
            if (i == 0) throw new java.util.NoSuchElementException();
            
            /*if (rand[i - 1] == null) 
            {
                i--;
                next();
            }*/
            
           return rand[--i];
       }       
       public void remove() { throw new java.lang.UnsupportedOperationException(); }
   }
   
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
       return new RandomIterator();
   }
   
   public static void main(String[] args)   
   {
    
   }
}