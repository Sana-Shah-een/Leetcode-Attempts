class Solution {
    public int searchInsert(int[] nums, int target) {
        //O(logn)
// Solution-1: Binary search se index find kia
    //    int start=0;
    //    int end=nums.length-1;
    //    while(start<=end){
    //     int mid=start+(end-start)/2;

    //     if(target==nums[mid]){
    //         return mid;
    //     }
    //     else if(target>nums[mid]){
    //         start=mid+1;
    //     }else{
    //         end=mid-1;
    //     }
    //    }
    // //always return start bcoz end=last smaller element index ,
    // // while start = correct insert position
    //    return start;

//Solution-2: O(n)
        // for (int i=0;i<nums.length;i++){
        //     if(nums[i]>=target){
        //         return i;
        //     }
        // }
        // return nums.length;

//Solution-3: O(logn)
        int index=Arrays.binarySearch(nums,target);
        return index>=0? index:-index-1;
    }
}