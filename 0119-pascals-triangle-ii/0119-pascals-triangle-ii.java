import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            row.add(1); //run for 1st index and last index must 
            for(int j=i-1;j>0;j--){ // e.g i=2 j=1 
                // row.get(1) = [1,1] at index 1 is = 1
                //row.get(j-1) = row.get(0) = 1
                // row.set(1,1+1) = row.set(1,2) = [1,2,1] 
                row.set(j,row.get(j)+row.get(j-1));
            }
        }
        return row;
        
    }
}