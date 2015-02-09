/**
 *
 * @author r.egorov
 */
public class Percolation {
    
    private WeightedQuickUnionUF uf;
    private boolean[][] items;
    private int size;
    
   public Percolation(int N)
   {               
       uf = new WeightedQuickUnionUF(N*N + 2);
       items = new boolean[N][N];
       size = N;
   }
   public void open(int i, int j)
   {
        if (i < 1 || i > size || j < 1 || j > size)
           throw new IndexOutOfBoundsException();
    
        if (isOpen(i, j)) return;
       
        items[i-1][j-1] = true;
       
        int index = getIndex(i, j);
       
        if (i == 1 && !uf.connected(index, 0)) uf.union(index, 0);
        if (i == size && !uf.connected(index, 2*size + 1)) 
            uf.union(index, 2*size + 1);
       
        if (i > 1 && isOpen(i-1, j) && !uf.connected(index, getIndex(i-1, j)))
            uf.union(index, getIndex(i-1, j));
       
        if (i < size && isOpen(i+1, j) && !uf.connected(index, getIndex(i+1, j)))
            uf.union(index, getIndex(i+1, j));
       
        if (j > 1 && isOpen(i, j - 1) && !uf.connected(index, getIndex(i, j - 1)))
            uf.union(index, getIndex(i, j-1));
       
        if (j < size && isOpen(i, j + 1) && !uf.connected(index, getIndex(i, j + 1)))
            uf.union(index, getIndex(i, j + 1));       
   }
   
   private int getIndex(int i, int j)
   {
       return (i - 1)*size + j;
   }
   
   public boolean isOpen(int i, int j)
   {
       if (i < 1 || i > size || j < 1 || j > size)
           throw new IndexOutOfBoundsException();
       
       return items[i-1][j-1];
   }
   
   public boolean isFull(int i, int j)
   {
       if (i < 1 || i > size || j < 1 || j > size)
           throw new IndexOutOfBoundsException();
       
       int index = getIndex(i, j);
       return uf.connected(0, index);
   }
   
   public boolean percolates()
   {
       return uf.connected(0, 2*size + 1);
   }             

   public static void main(String[] args)
   {
       int N = 20;
       Percolation perc = new Percolation(N);
       int count = 0;
       while (!perc.percolates())
       {
           int i = StdRandom.uniform(1, N+1);
           int j = StdRandom.uniform(1, N+1);
           
           if (!perc.isOpen(i, j))
           {
               perc.open(i, j);
               count++;
           }           
       }
       
       StdOut.println("N = " + N + ", count = " + count + ", p = " 
                        + count/(N*N));
       StdIn.readChar();
   }   
}
