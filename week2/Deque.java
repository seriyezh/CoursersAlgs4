public class Deque<Item> implements Iterable<Item> {
    
    private Item[] a;
    private int N;
    
   /**
    * construct an empty deque
    */
    public Deque(){
        a = (Item[]) new Object[2];
    }
    
    /**
     * is the deque empty?
     */
    public boolean isEmpty(){
        return N == 0;
    }
    /**
     * return the number of items on the deque
     */
    public int size(){
        return N;
    }
    
    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    
    /**
     * insert the item at the front
     */
    public void addFirst(Item item){
        if(item == null) throw new NullPointerException("Null item isn't allowed");
        
        N++;        
        if(N == a.length)
			resize(2*a.length);		
                
        for(int i = N; i >= 0; i--){
            a[i+1] = a[i];
        }
        a[0] = item;;
    }
    
    /**
     * insert the item at the end
     */
    public void addLast(Item item){
        if(item == null) throw new NullPointerException("Null item isn't allowed");        
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    
    /**
     * delete and return the item at the front
     */
    public Item removeFirst(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[0];
        
        for(int i = 1; i < N; i++){
            a[i-1] = a[i];
        }
        a[N] = null;
        N--;
        return item;
    }
    
    /**
     * delete and return the item at the end
     */
    public Item removeLast(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[N-1];
        a[N-1] = null;                              // to avoid loitering
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;        
    }
    
    /**
     * return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = N;
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }
    }
    
    /**
     * unit testing
     */
    public static void main(String[] args){
        Deque<String> s = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.addLast(item);
            else if (!s.isEmpty()) StdOut.print(s.removeFirst() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}