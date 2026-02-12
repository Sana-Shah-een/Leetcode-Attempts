// import.java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
 // Solution-1: O(m+n) Time Complexity , O(1) Space Complexity

    //  Classic two-pointer from the end problem.
    // Since nums1 already has extra space, we fill it backwards to avoid   overwriting elements.


       //accessing both arrays last index
        int i=m-1;
        int j=n-1;
        //new array index equal to both arrays size m+n (-1 add bcz index start from zero)
        int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
       
        // if nums2 still has elements, copy them
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }

        // // Solution-2:  Time: O((m+n) log(m+n)), Space: O(1)

        //  // copy nums2 elements into nums1
        // for (int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }

        // // sort the final array
        // Arrays.sort(nums1);
    }
}