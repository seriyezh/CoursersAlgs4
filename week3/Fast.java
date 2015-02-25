import java.util.Arrays;

public class Fast {
   public static void main(String[] args)
   {
        if (args.length == 0)
        {
            StdOut.println("Enter file name, please!");
            return;
        }
        
        In in = new In(args[0]);
        //StdOut.println(args[0]);
        
        int count = in.readInt();
        //StdOut.println(count);
        
        Point[] a = new Point[count];        
        for (int i = 0; !in.isEmpty() || i < count; i++)
        {
            a[i] = new Point(in.readInt(), in.readInt());            
        }
        
        /*for (int i = 0; i < count; i++){
            StdOut.println(a[i]);
        }*/
        
        for (int i = 0; i < count; i++) 
        {
            Point p = a[i];            
            Arrays.sort(a, p.SLOPE_ORDER);
         
            /*for (int kl = 0; kl < count; kl++){
                StdOut.println(a[kl]);                
            }
            StdOut.println();*/
         
            int lo = 0, index = 0, hi = 0;
            while (index < a.length - 1)
            {
                if(a[index] == p)
                {
                    index++;
                    continue;
                }
            
                if (a[index].slopeTo(p) == a[index + 1].slopeTo(p))
                {
                    hi = index + 1;
                    if (index > 0 && a[index].slopeTo(p) != a[index - 1].slopeTo(p)) lo = index;
                }
                
                index++;
            }
            
            //StdOut.println(hi + ", " + lo);
            
            if (hi - lo >= 2)
            {
                StdOut.println(p + " -> " + a[lo] + " -> " 
                                        + a[lo + 1] + " -> " + a[lo + 2]);
            }            
        }
   }
}