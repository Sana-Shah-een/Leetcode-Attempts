import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //list contains list = [[]] initially empty
        List<List<Integer>> result = new ArrayList<>();

        //list contains elements=susets [ , , , ] initially empty
        List<Integer> subset = new ArrayList<>();

        //function for generating subsets (backtracking)
        generateSubsets(nums,0,subset,result);
        return result;
    }

    private static void generateSubsets(int[] nums,int index,List<Integer> subset,List<List<Integer>> result){
        //this is the base case when last element hit then it adds the suset in result list 
        if(index==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //include nums[index]
        subset.add(nums[index]);
        generateSubsets(nums,index+1,subset,result);

        //exclude nums[index] backtracking
        subset.remove(subset.size()-1);
        generateSubsets(nums,index+1,subset,result);

    }
}