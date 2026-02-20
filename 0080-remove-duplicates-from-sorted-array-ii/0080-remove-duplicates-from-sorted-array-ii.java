class Solution {
    public int removeDuplicates(int[] nums) {
//Time Complexity: O(N) , Space Complexity: O(1)
        int k=2;
//i iterates from index 2 bcoz unique element appears atmost twice e.g.[1,1,2,2,3]
        for(int i=2;i<nums.length;i++){
//check index 2 element != its previous 2 elements if not equal then we copy elements in array otherwise skip 
            if(nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }       
        return k; 
    }
}