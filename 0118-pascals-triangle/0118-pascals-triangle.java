class Solution {
    public List<List<Integer>> generate(int numRows) {
    //Time Complexity +space complexity  = O(n'2)
    // 1+2+3+...+n = n(n+1)/2 =O(n'2)
       List<List<Integer>> ans =new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> row =new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(ans.get(i-1).get(i-j)+ans.get(i-1).get(j));
                }
            }
            ans.add(row);
        }
         return ans;

    }
}