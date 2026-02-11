class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
    // last wale digit se loop start hogi that's why i starts from  n-1 
        for(int i=n-1;i>=0;i--){
        // if digit less that 9 than simply add 1 
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
        //else: if digit = 9
            digits[i] = 0;
        }
    // bcoz if digits = [9] then new result array equal to [n+1]-- result=[1,0] 
        int[] result = new int[n+1];
        result[0]=1;
        return result;

    }

}