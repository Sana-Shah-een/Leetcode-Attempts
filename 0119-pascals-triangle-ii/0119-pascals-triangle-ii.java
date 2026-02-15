// import java.util.ArrayList;

// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         // Time Complexity: O(n'2) , 
//         //Space Complexity: O(n) = sorting (rowIndex+1) elements
//         List<Integer> row = new ArrayList<>();
//         for(int i=0;i<=rowIndex;i++){
//             row.add(1); //run for 1st index and last index must 
//             for(int j=i-1;j>0;j--){ // e.g i=2 j=1 
//                 // row.get(1) = [1,1] at index 1 is = 1
//                 //row.get(j-1) = row.get(0) = 1
//                 // row.set(1,1+1) = row.set(1,2) = [1,2,1] 
//                 row.set(j,row.get(j)+row.get(j-1));
//             }
//         }
//         return row;
        
//     }
// }

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
    // Time Complexity: O(N)
    // Space Complexity : O(N)
        List<Integer> row = new ArrayList<>();
        long value = 1;  // use long to avoid overflow
        
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) value);
        // Instead of O(n²) DP updating, we can use Math formula (nCr):
        // C(n,k)=C(n,k−1)∗(n−k+1)/k
            value = value * (rowIndex - i) / (i + 1);
        }
        
        return row;
    }
}
