class Solution {
    public static void rotate(int[] a, int k){
        int n = a.length;
        k = k % n; // true rotation number 
        
        if(k < 0){
            // -ve rotation -> +ve rotation number
            k = k + n;
        }
        
        // arr = p1 + p2
        
        reverse(a,n-k,n-1);// reverse part2
        reverse(a,0,n-k-1);// reverse part1
        reverse(a,0,n-1);// reverse a
      }
      
      // reverse(a,lo,hi) : reverse part of array from [lo->hi]
      public static void reverse(int a[],int lo,int hi){
          while(lo < hi){
              int tmp = a[lo];
              a[lo] = a[hi];
              a[hi] = tmp;
              
              lo++;
              hi--;
          }
      }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int arr[] = new int[grid.length*grid[0].length];
        int idx = 0;
        for(int row[] : grid){
            for(int vl : row){
                arr[idx++] = vl;
            }
        }
        
        rotate(arr,k);
        
        List<List<Integer>> res = new ArrayList<>();
        int m = grid[0].length;
        List<Integer> help = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(m == 0){
                res.add(help);
                help = new ArrayList<>();
                m = grid[0].length;
            }
                m--;
            help.add(arr[i]);
        }
        res.add(help);
        
        return res;
    }
}

// Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

// In one shift operation:

// Element at grid[i][j] moves to grid[i][j + 1].
// Element at grid[i][n - 1] moves to grid[i + 1][0].
// Element at grid[m - 1][n - 1] moves to grid[0][0].
// Return the 2D grid after applying shift operation k times.

 

// Example 1:
// Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
// Output: [[9,1,2],[3,4,5],[6,7,8]]