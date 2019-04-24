/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    public static ArrayList a = new ArrayList<Integer>();
    
	public static boolean subsetSum(int[] set, int sum) {
        boolean[][] arr = new boolean[set.length + 1][sum + 1];
        int[][] b = new int[set.length + 1][sum + 1];
        for (int i = 0; i < set.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j > 0) {
                    arr[i][j] = false;
                } else if (j == 0) {
                    arr[i][j] = true;
                }
            }
        }
        for (int i = 1; i < set.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                boolean a1 = arr[i - 1][j];
                boolean a2 = ((j - set[i - 1]) >= 0 ? arr[i - 1][j - set[i - 1]] : false);
                if (a2) {
                    b[i][j] = 2;
                } else if (a1) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = 0;
                }
                arr[i][j] = a1 || a2;
            }
        }
        printSubSet(set, b, set.length, sum);
        return arr[set.length][sum];
    }
 
    private static void printSubSet(int[] set, int[][] b, int n, int m) {
        if (b[n][m] == 1) {
            printSubSet(set, b, n - 1, m);
        } else if (b[n][m] == 2) {
            printSubSet(set, b, n - 1, m - set[n - 1]);
            System.out.println(set[n - 1] + "hh");
            a.add(set[n - 1]);
        }
 
    }
 
    public static int FindMaxSum(int arr[], int n) 
    { 
        int incl = arr[0]; 
        int excl = 0; 
        int excl_new; 
        int i; 
  
        for (i = 1; i < n; i++) 
        { 
            excl_new = (incl > excl) ? incl : excl; 
            incl = excl + arr[i]; 
            excl = excl_new; 
        } 
  
        return ((incl > excl) ? incl : excl); 
    } 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0)
        {
            int n = in.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = in.nextInt();
            
            int sum = FindMaxSum(a, n);
            // System.out.println(sum);
            
            System.out.println(subsetSum(a, sum));
            for(int x: a)
                System.out.print(x + " ");
        }
    }
}