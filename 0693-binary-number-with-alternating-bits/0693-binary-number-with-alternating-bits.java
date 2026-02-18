class Solution {
    public boolean hasAlternatingBits(int n) {
// Solutio-1: BitManipulation Approach
        int previousBit=n&1; //give last binary bit 
        n=n>>1;  //right shift (last bit remove hojae gi)

        while(n>0){
        // again get last bit
            int currentBit=n&1;
        // check the previousBit equal to currBit then return false 
            if(currentBit==previousBit){
                return false;
            }
        // update previousBit = currentBit
            previousBit=currentBit;
        // agin right Shift 
            n=n>>1;
        }
        return true;

// Solution-2: Remainder Approach
        // int currBit=n%2;
        // n=n/2;
        // while(n>0){
        //     if(currBit==n%2){
        //         return false;
        //     }
        //     currBit=n%2;
        //     n=n/2;
        // }
        // return true;

    }
}