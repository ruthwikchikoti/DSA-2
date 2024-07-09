import java.util.*;
public class DyanamicProramming {
    // using dp fibinacci  series code
    public static int fib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // using recursion using dynamic programming

    public static int fib_rec(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fib_rec(n-1,dp)+fib_rec(n-2,dp);
        return dp[n];
    }

    // in howm many ways we can reach the top of the stairs if we can take 1 or 2 steps at a time
    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // using recursion
    public static int climbStairs_rec(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = climbStairs_rec(n-1,dp)+climbStairs_rec(n-2,dp);
        return dp[n];
    }

    // given an array of integers find the maximum sum of non adjacent elements
    public static int maxSum(int[] arr){
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[arr.length-1];
    }
    // using recursion only input is array
    public static int maxSum_rec(int arr[]){
        return maxSum_rec(arr,arr.length-1);


    }
    public static int maxSum_rec(int arr[],int n){
        if(n==0){
            return arr[0];
        }
        if(n==1){
            return Math.max(arr[0],arr[1]);
        }
        return Math.max(maxSum_rec(arr,n-1),maxSum_rec(arr,n-2)+arr[n]);
    }

    // lets party problem one person can party either alone or can pair up with another person.

    //Can you find in how many ways they can party if there are A people in Danceland?
    public static int party(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }

    // count the number of ways (0,0) to (m-1,n-1) in a 2D matrix,from any cell you can either go down or right
    public static int uniquePaths_rec(int m,int n){
        return validpaths(0,0,m,n);
    }
    public static int validpaths(int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        return validpaths(i+1,j,m,n)+validpaths(i,j+1,m,n);
    }
    public static int uniquePaths_dp(int m,int n){
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    // mim path sum
    public static int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    // using recursion
    public static int minPathSum_rec(int[][] grid){
        return minPathSum_Rec(grid,0,0);
    }
    public static int minPathSum_Rec(int[][] grid,int i,int j){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
            
        }
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        return grid[i][j]+Math.min(minPathSum_Rec(grid,i+1,j),minPathSum_Rec(grid,i,j+1));
    }


    // return longest common subsequence
    public static int lcs(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // using recursion  
    public static int lcs_rec(String s1,String s2){
        return lcs_rec(s1,s2,s1.length(),s2.length());
    }
    public static int lcs_rec(String s1,String s2,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+lcs_rec(s1,s2,m-1,n-1);
        }
        else{
            return Math.max(lcs_rec(s1,s2,m-1,n),lcs_rec(s1,s2,m,n-1));
        }
    }
    

    // edit distance
    // given 2 strings s1 and s2,find the minimum number of operations required to convert s1 to s2
    public static int editDistance(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                else if(j==0){
                    dp[i][j] = i;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
    // using recursion
    public static int editDistance_rec(String s1,String s2){
        return editDistance_rec(s1,s2,s1.length(),s2.length());
    }
    public static int editDistance_rec(String s1,String s2,int m,int n){
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return editDistance_rec(s1,s2,m-1,n-1);
        }
        else{
            return 1+Math.min(editDistance_rec(s1,s2,m-1,n-1),Math.min(editDistance_rec(s1,s2,m-1,n),editDistance_rec(s1,s2,m,n-1)));
        }
    }


    // given 2 string s,with ? ,* find if the string matches the pattern or not like a*b matches aaab or aab easy code
    // public static

















    // given 2 string A & B count the number of ways in which we can get String B as a subsequence of String A
    public static int countSubsequence(String A,String B){
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(i==0){
                    dp[i][j] = 0;
                }
                else if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }


    // lps longest palindromic subsequence given a string s return the length of the longest palindromic subsequence
    public class Solution {
        private int[][] dp;

        public int lps(String s) {
            int n = s.length();
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            return lpsUtil(s, 0, n - 1);
        }

        private int lpsUtil(String s, int i, int j) {
            if (i > j) {
                return 0;
            }
            if (i == j) {
                return 1;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 2 + lpsUtil(s, i + 1, j - 1);
            } else {
                dp[i][j] = Math.max(lpsUtil(s, i + 1, j), lpsUtil(s, i, j - 1));
            }
            return dp[i][j];
        }
    }
    // using recursion
    public static int lps_rec(String s){
        return lps_rec(s,0,s.length()-1);
    }
    public static int lps_rec(String s,int i,int j){
        if(i==j){
            return 1;
        }
        if(s.charAt(i)==s.charAt(j) && i+1==j){
            return 2;
        }
        if(s.charAt(i)==s.charAt(j)){
            return 2+lps_rec(s,i+1,j-1);
        }
        return Math.max(lps_rec(s,i+1,j),lps_rec(s,i,j-1));
    }                                  
    
    

    // given n wines,each year you can sell either the left most or the right most wine,price of the wine increases over time(p[i]*y) calculate the maximum profit
    public static int maxProfit(int[] wines){
        int n = wines.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = wines[i]*n;
        }
        
        for(int len=2;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j = i+len-1;
                int year = n-(j-i);
                dp[i][j] = Math.max(wines[i]*year+dp[i+1][j],wines[j]*year+dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }

    // using recursion
    public static int maxProfit_rec(int[] wines){
        return maxProfit_rec(wines,0,wines.length-1,1);
    }
    public static int maxProfit_rec(int[] wines,int i,int j,int year){
        if(i>j){
            return 0;
        }
        if(i==j){
            return wines[i]*year;
        }
        return Math.max(wines[i]*year+maxProfit_rec(wines,i+1,j,year+1),wines[j]*year+maxProfit_rec(wines,i,j-1,year+1));
    }

    // given n items with their weights and values and a knapsack of capacity W,find the maximum value that can be obtained by picking items such that the total weights is less than or equal to max capacity
    // every item can be picked only once
    // taking an item partially is not allowed
    // using recursion
    public static int knapsack(int[] wt,int[] val,int W){
        return knapsack(wt,val,wt.length-1,W);
    }
    public static int knapsack(int[]wt ,int[] val,int i,int w){

      if( i < 0) return 0;
      if( w == 0) return 0;
      int ans = knapsack(val, val, i-1,w);
      if(wt[i]<=w){
          ans = Math.max(ans,val[i]+knapsack(wt,val,i-1,w-wt[i] + val[i]));
      }
        return ans;
    }

    // using dp
    public static int knapsack_dp(int[] wt,int[] val,int W){
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }




    //

    // word break ,return true if the string can be segmented into a space separated sequence of one or more dictionary words
    // using recursion
    public static boolean wordBreak(String s,List<String> wordDict){
        return wordBreak(s,new HashSet<>(wordDict),0);
    }
    public static boolean wordBreak(String s,Set<String> wordDict,int start){
        if(start==s.length()){
            return true;
        }
        for(int end=start+1;end<=s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && wordBreak(s,wordDict,end)){
                return true;
            }
        }
        return false;
    }
    // using dp
    public static boolean wordBreak_dp(String s,List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    // palindrome partitioning in dp 
    
    // using recursion
    public static int minCut_rec(String s){
        return minCut_rec(s,0,s.length()-1);
    }
    public static int minCut_rec(String s,int i,int j){
        if(i>=j || isPalindrome(s,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = 1+minCut_rec(s,i,k)+minCut_rec(s,k+1,j);
            ans = Math.min(ans,temp);
        }
        return ans;
    }
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



    // given n number of matrices find the minimum number of multiplications needed to multiply the matrices 
    // return the minimum number of multiplications needed to multiply the matrices
        public static int matrixChainMultiplication(int s , int e,int[]R,int [] C){
            int ans  = Integer.MAX_VALUE;
            for(int i =s ; i<=e;i++){
                 ans = Math.min(ans,matrixChainMultiplication(s, i,R,C))+matrixChainMultiplication(i+1,e,R,C)+R[s]*R[i]*C[e];
            }
         return ans;
        }
    public static void main(String[] args) {
        // System.out.println(countSubsequence("RABYBXBIT", "RABBIT"));
        // System.out.println(maxProfit_rec(new int[]{2,4,6,2,5}));
        // System.out.println(lcs_rec("bebdeeedaddecebbbbbabebedc","abaaddaabbeacbcdcaaed"));
        System.out.println(knapsack(    new int[]{10,20,30},new int[]{60,100,120},50));
    }

}

    