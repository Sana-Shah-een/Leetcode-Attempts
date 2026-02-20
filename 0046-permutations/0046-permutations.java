import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backTrack(nums,new ArrayList<>(),result);
        return result;
    }
    public void backTrack(int[] nums,List<Integer> list, List<List<Integer>> result){
        // Base case: if list size equals array length
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue; //element already exists, skip
            list.add(nums[i]);
            backTrack(nums,list,result);
            list.remove(list.size()-1);
        }
    }
}