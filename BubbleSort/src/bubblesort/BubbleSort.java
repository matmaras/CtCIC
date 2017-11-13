package bubblesort;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int numberOfSwaps = swap2(n, a);
        
    	System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
    	System.out.println("First Element: " + a[0]);
    	System.out.println("Last Element: " + a[n - 1]);
    }
    
	private static int swap2(int n, int[] a) {
		int numberOfSwaps = 0;
        
        for (int j = 0; j < n - 1; j++) {
	        for (int i = 0; i < n - 1; i++) {
	        	if(a[i] > a[i+1]) {
	        		a[i] = a[i] ^ a[i+1];
	        		a[i+1] = a[i] ^ a[i+1];
	        		a[i] = a[i] ^ a[i+1];
	        		numberOfSwaps++;
	        	}
	        }
	        
	        if (numberOfSwaps == 0) {
	            break;
	        }
        }
		return numberOfSwaps;
	}

	private static int swap1(int n, int[] a) {
		int numberOfSwaps = 0;
        
        for (int j = 0; j < n - 1; j++) {
	        for (int i = 0; i < n - 1; i++) {
	        	if(a[i] > a[i+1]) {
	        		int tmp = a[i+1];
	        		a[i+1] = a[i];
	        		a[i] = tmp;
	        		numberOfSwaps++;
	        	}
	        }
	        
	        if (numberOfSwaps == 0) {
	            break;
	        }
        }
		return numberOfSwaps;
	}
}
