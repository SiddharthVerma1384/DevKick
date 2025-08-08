
import java.util.*;
class Buy_n_Sell_Stocks{
    public static int MAX_PROFIT(int prices[]){
        int BuyPrice = Integer.MAX_VALUE;
        int MaxProfit = 0;
        for(int i =0; i<prices.length; i++){
            if (BuyPrice < prices[i]){
                int profit = prices[i] - BuyPrice ;
                MaxProfit = Math.max(profit , MaxProfit);
            }else{
                BuyPrice = prices[i];
            }
        }
        return MaxProfit;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int prices[] = {7,1,5,3,6,4};
        System.out.print("Max Profit : " + MAX_PROFIT(prices));
    }
}
