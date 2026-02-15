class Solution {
    public int maxProfit(int[] prices) {
        // Time Complexity : O(N) , Space Complexity : O(1)
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            // if(price<minPrice){
            //     minPrice = price;
            // }else if(price - minPrice > maxProfit){
            //     maxProfit = price - minPrice;
            // }
            minPrice = Math.min(minPrice,price);
            maxProfit = Math.max(maxProfit,price-minPrice);
        }          
        return maxProfit;
    }
}