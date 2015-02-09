/**
 *
 * @author r.egorov
 */
public class PercolationStats {
    
    private double[] x;
    private int T;
    private double mean;
    private double stddev;
    
    /**
     * perform T independent experiments on an N-by-N grid
     * @param N
     * @param T 
     */
    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        
        this.T = T;
        x = new double[T];
        mean = 0;
        stddev = 0;
        
        for (int k = 0; k < T; k++)
        {
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
            
            x[k] = count/(N*N);
        }
    } 
   
    /**
     * sample mean of percolation threshold
     * @return 
     */
    public double mean()
    {
        double sum = 0;
        for (int i = 0; i < T; i++)
            sum += x[i];
        
        this.mean = sum/T;
        
        return this.mean;
    }
   
   /**
    * sample standard deviation of percolation threshold
    * @return 
    */
   public double stddev()
   {
       double meanlocal;
       if (this.mean != 0)
            meanlocal = this.mean;
       else
            meanlocal = this.mean();
       
       double sum = 0;
       for (int i = 0; i < T; i++)
           sum += (x[i] - meanlocal)*(x[i] - meanlocal);
       
       this.stddev = Math.sqrt(sum/(T - 1));
       
       return this.stddev;
   }
   
   /**
    * low  endpoint of 95% confidence interval
    * @return 
    */
   public double confidenceLo()
   {
       return mean - (1.96*this.stddev/Math.sqrt(T));
   }
   
   /**
    * high endpoint of 95% confidence interval   
    * @return 
    */
   public double confidenceHi()
   {
       return mean + (1.96*this.stddev/Math.sqrt(T));
   }

   /**
    * test client (described below)
    * @param args 
    */
   public static void main(String[] args)
   {
       int[] arg = StdIn.readInts();
       
       PercolationStats stats = new PercolationStats(arg[0], arg[1]);
       
       StdOut.println("mean                    = " + stats.mean());
       StdOut.println("stddev                  = " + stats.stddev());
       StdOut.println("95% confidence interval = " + stats.confidenceLo() 
                        + ", " + stats.confidenceHi());
   }
}
