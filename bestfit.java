// Java implementation of Best - Fit algorithm

import java.util.*;
public class BESTFIT
{
	// Method to allocate memory to blocks as per Best fit
	// algorithm
	static void bestFit(int blockSize[], int m, int processSize[],
													int n)
	{
		// Stores block id of the block allocated to a
		// process
		int allocation[] = new int[n];
	
		// Initially no block is assigned to any process
		for (int i = 0; i < allocation.length; i++)
			allocation[i] = -1;
	
	// pick each process and find suitable blocks
		// according to its size ad assign to it
		for (int i=0; i<n; i++)
		{
			// Find the best fit block for current process
			int bestIdx = -1;
			for (int j=0; j<m; j++)
			{
				if (blockSize[j] >= processSize[i])
				{
					if (bestIdx == -1)
						bestIdx = j;
					else if (blockSize[bestIdx] > blockSize[j])
						bestIdx = j;
				}
			}
	
			// If we could find a block for current process
			if (bestIdx != -1)
			{
				// allocate block j to p[i] process
				allocation[i] = bestIdx;
	
				// Reduce available memory in this block.
				blockSize[bestIdx] -= processSize[i];
			}
		}
	
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < n; i++)
		{
			System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
			if (allocation[i] != -1)
				System.out.print(allocation[i] + 1);
			else
				System.out.print("Not Allocated");
			System.out.println();
		}
	}
	
	// Driver Method
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Block sizes: ");
		int m = sc.nextInt();
		System.out.print("Enter the number of Process sizes: ");
		int n = sc.nextInt();
		int blockSize[] = new int[m];
		int processSize[] = new int[n];
		for(int i = 0; i < m; i++) {
			System.out.print("Enter the Block size of process no " + (i+1) + ": ");
			blockSize[i] = sc.nextInt();
			
		}
		
		for(int i = 0; i< n; i++) {
			System.out.print("Enter the Process size of process no " + (i+1) +  ": ");
			processSize[i] = sc.nextInt();
		}
	
		
		bestFit(blockSize, m, processSize, n);
	}
}
