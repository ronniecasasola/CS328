/*
 * author: Ronald Casasola 012737398
 * 
 */
import java.util.ArrayList;

public class MatrixChainOrder {

	//initialize arrays m,s
	private int[][] m;
    private int[][] s;
    private int     n;
    
    public int[][] getM(){
    	return m;
    }
    
	public MatrixChainOrder(ArrayList<int[][]> arr) {
		int[][] temp;
		ArrayList<Integer> a = new ArrayList<Integer>();
		temp = (int[][]) arr.get(0);
		a.add(temp[0][0]);
		for(int i = 0; i < arr.size(); i++) {
			a.add(arr.get(i)[0][1]);
		}
		//converted array to be used in algorithm
		Integer[] array = a.toArray(new Integer[0]);
		
		//how many matrices are in the chain
		n = array.length - 1;
		m = new int[n+1][n+1];
		s = new int[n+1][n+1];
		
		// initial value of empty subproblems
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        // solve chains of length l
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Check each possible split to determine if better
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + array[i - 1] * array[k] * array[j];
                    if (q < m[i][j])
                    {
                        // for q is optimal split
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
	}
	
	//prints the optimal parents of the matrix
	private String printOptimalParents(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParents(i, s[i][j])
                    + printOptimalParents(s[i][j] + 1, j) + " )";
    }
 
    public String toString()
    {
        return printOptimalParents(1, n);
    }
    
	
}
