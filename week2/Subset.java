public class Subset
{
    public  static void main(String[] args)
    {
        int k = StdIn.readInt();
        String[] strings = StdIn.readStrings();
        
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        for (int i = 0; i < strings.length; i++)
        {
            queue.enqueue(strings[i]);
        }
        
        for (int i = 0; i < k; i++)
            StdOut.println(queue.dequeue());        
    }
}