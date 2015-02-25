/*----------------------------------------------------------------
 *  Author:        Roman Yegorov
 *  Written:       10/6/2014
 *  Last updated:  10/6/2014
 *
 *  Compilation:   javac Brute.java
 *  Execution:     java Brute
 *
 *----------------------------------------------------------------*/

public class Brute {
    public static void main(String[] args){
        
		if(args.length == 0)
		{
			StdOut.println("Enter file name, please!");
			return;
		}
		
        In in = new In(args[0]);
		StdOut.println(args[0]);
		
        int count = in.readInt();
        StdOut.println(count);
		
        Point[] a = new Point[count];        
        for(int i = 0; !in.isEmpty() || i < count; i++){
            a[i] = new Point(in.readInt(), in.readInt());            
        }
        
        /*for (int i = 0; i < count; i++){
            StdOut.println(a[i]);
        }*/
        	
        for(int i = 0; i < count; i++){
            for(int j = i+1; j < count; j++){
                for(int k = j+1; k < count; k++){
                    for(int l = k+1; l < count; l++){
                        if(a[i].slopeTo(a[j]) == a[i].slopeTo(a[k]) && a[i].slopeTo(a[j]) == a[i].slopeTo(a[l]))
							StdOut.println(a[i] + " -> " + a[j] + " -> " + a[k] + " -> " + a[l]);
                    }
                }
            }
        }
    }
}