/*
 * @author: Ronald Casasola
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

public class MemoizedCutRod {

	public int MemoizedCutRod(int[][] p, int n) {
		//initializes new array
		int[] r = new int [n+1];
		for(int i = 0; i <= n; i++) {
			//initializes all values of array to negative
			r[i] = -1000;
		}
		return MemoizedCutRodAux(p, n , r);
	}

	public int MemoizedCutRodAux(int[][] p, int n, int[] r) {
		
		int[] size = new int[n + 1];
		
		
		//initialize q
		int q = 0;
		//checks to see if we already have the solution
		if(r[n] >= 0) {
			return r[n];
		}
		if(n==0) {
			q = 0;
		} 
		else{
			//sets q to negative because a found solution will always be postive
			q = -1000;
			for(int i = 1; i <= n; i++) {
				//recursive function call
				int q2 = MemoizedCutRodAux(p,n-i,r);
				//compares q and the addition of p[1][i-1] and q2
				q = Math.max(q, p[1][i-1] + q2);
				if(q < Math.max(q, p[1][i-1] + q2)) {
					size[i] = i+1;
				}
			}
			
		}
		//stores the solution
		r[n] = q;
		return q;
	}
	
	//bottomup cut rod to help get which rods were chose
	public void printCutRodSizes(int[][] prices, int n) {
        int[] revs = new int[n + 1];
        int[] size = new int[n + 1];
        
        revs[0] = 0;
        int max = -1000;
        for (int j = 1; j <= n; j++) {
            max = -1000;
            for (int i = 0; i < j; i++) {
                if (max < prices[1][i] + revs[j - i - 1]) {
                    max = prices[1][i] + revs[j - i - 1];
                    size[j] = i + 1;
                }
            }
            revs[j] = max;
        }
        
        //returns 2d array of revenues and sizes
        int[][] rs = new int[2][n + 1];
        for (int i = 0; i < n + 1; i++) {
            rs[0][i] = revs[i];
            rs[1][i] = size[i];
        }
        
        int[] num = rs[1];
        while (n > 0) {
            System.out.println("Size of chosen rod: " + num[n] + " Price of rod: $" + rs[0][num[n]]);
            n -= num[n];
        }
        
    }
	    
}
