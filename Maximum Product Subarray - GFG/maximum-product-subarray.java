//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long res = Integer.MIN_VALUE;
        long productFront = 1;
        long productBack = 1;
        
        for(int i=0;i<n;i++){
           productFront = productFront*arr[i];
           productBack = productBack*arr[n-i-1];
           
           res = Math.max(res,Math.max(productFront,productBack));
           if(productFront==0){
               productFront = 1;
           }
           
           if(productBack==0){
               productBack = 1;
           }
        }
        
        return res;
    }
}