/ Java program for next fit
// memory management algorithm

import java.util.*;
public class NEXTFIT {
 
// Function to allocate memory to blocks as per Next fit
// algorithm
    static void NextFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n], j = 0;
 
        // Initially no block is assigned to any process
        Arrays.fill(allocation, -1);
 
        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Do not start from beginning
            while (j < m) {
                if (blockSize[j] >= processSize[i]) {
 
                    // allocate block j to p[i] process
                    allocation[i] = j;
 
                    // Reduce available memory in this block.
                    blockSize[j] -= processSize[i];
 
                    break;
                }
 
                // mod m will help in traversing the blocks from
                // starting block after we reach the end.
                j = j+1;
            }
            j = 0;
        }
 
        System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
        for (int i = 0; i < n; i++) {
            System.out.print( i + 1 + "\t\t" + processSize[i]
                    + "\t\t");
            if (allocation[i] != -1) {
                System.out.print(allocation[i] + 1);
            } else {
                System.out.print("Not Allocated");
            }
            System.out.println("");
        }
    }
 
// Driver program
    static public void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of blocks: ");
        int nb = sc.nextInt();
        System.out.print("Enter the number of processes: ");
        int np = sc.nextInt();
        int blockSize[] = new int[nb];
        int processSize[] = new int[np];

        System.out.println("Enter " + nb + " blocks: ");
        for(int i = 0; i < nb; i++) {
            blockSize[i] = sc.nextInt();
        }


        System.out.println("Enter " + np + " processes: ");
        for(int i = 0; i < np; i++) {
            processSize[i] = sc.nextInt();
        }

        System.out.println("Input complete");
  
        NextFit(blockSize, nb, processSize, np);
    }
}
 

 
