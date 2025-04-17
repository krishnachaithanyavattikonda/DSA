package MostAsked.Arrays;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int n = prices.length;
        int buyAt = prices[0];
        int profit = 0;
        for(int i=1; i<n; i++){
            if(prices[i] < buyAt){
                buyAt = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyAt);
        }
        return profit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
