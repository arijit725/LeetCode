package org.arijit.matrix;

import java.util.Arrays;

/**
 * Leetcode 2428: Maximum sum of an Hourglass
 *
 * My Note: This is a matrix problem which could be solve in a brute force manner using 3 loop.
 * But we can optimize this using presum and sliding window teechnique:
 *  1. First pre-compute the sum for each row in a matrix starting from 0 to jth column
 *  2. Now use a sliding window, where the sum value till exiting column from window will be substracted from sum till jth column.
 *
 *  [Accecpted by Leetcode]
 * @author Arijit Ghosh
 */
public class Hourglass {

    public int maxSum(int[][] grid) {
        int[][] ref = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            int sum = 0;
            for(int j=0;j<grid[0].length;j++){
                sum = sum + grid[i][j];
                ref[i][j] = sum;
            }
        }

//hourglass has pattern to involve 3 row and 3 column.
        int maxSofar = 0;
        for(int i=2;i<grid.length;i++){
            int sum = 0;
            for(int j=2;j<grid[0].length;j++){
                int starti = i-3+1;
                int startj = j-3+1;
                int mid = startj+(j-startj)/2;
                sum = (j-3)<0? (ref[starti][j]+ref[i][j]): (ref[starti][j]-ref[starti][j-3] + ref[i][j]-ref[i][j-3]);
                sum = sum + grid[starti+1][mid];
                maxSofar = Math.max(maxSofar, sum);
            }

        }

        return maxSofar;

    }

    public static void main(String args[]){
        int grid[][] = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};

        Hourglass hourglass = new Hourglass();
        int result = hourglass.maxSum(grid);
        System.out.println(result);

    }
}
