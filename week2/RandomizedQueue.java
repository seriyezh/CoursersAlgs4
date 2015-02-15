import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private int N;    
    private Item[] a = (Item[])new Object[1];
    
   public RandomizedQueue()                 // construct an empty randomized queue
   {}
   
   private void resize(int max)
   {
       Item[] temp = (Item[])new Object[max];
       int j = 0;
       for (int i = 0; i < a.length; i++)
           if (a[i] != null) 
           {
               temp[j++] = a[i];               
           }
       
       a = temp;
   }
   
   public boolean isEmpty()                 // is the queue empty?
   {
       return N == 0;
   }
   
   public int size()                        // return the number of items on the queue
   {
       return N;
   }
   
   public void enqueue(Item item)           // add the item
   {
       if (item == null) throw new java.lang.NullPointerException();
       
       if (N == a.length) resize(2*a.length);
       a[N++] = item;
   }
   
   public Item dequeue()                    // remove and return a random item
   {
       if (isEmpty()) throw new java.util.NoSuchElementException();
       
       int index = StdRandom.uniform(a.length);
       Item item = a[index];
       a[index] = null;
       N--;       
       
       if (N > 0 && N == a.length/4) resize(a.length/2);
       
       return item;
   }
   
   public Item sample()                     // return (but do not remove) a random item
   {
       if (isEmpty()) throw new java.util.NoSuchElementException();
       
       int index = StdRandom.uniform(a.length);
       return a[index];
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
   
   public static void main(String[] args)   // unit testing
   {
       RandomizedQueue<Integer> r = new RandomizedQueue<Integer>();
       for (int i = 0; i < 10; i++)
           r.enqueue(i);
       
       /*Iterator iterator = r.iterator();
       while (iterator.hasNext())
           StdOut.println(iterator.next());*/
       
       for (int i = 0; i < 10; i++)
           StdOut.println(r.dequeue());
   }
}