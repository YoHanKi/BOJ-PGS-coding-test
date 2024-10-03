import java.util.*;

class Solution {
    int[] PERCENTS = {10, 20, 30, 40};
    int MAX_PLUS = Integer.MIN_VALUE;
    int MAX_PRICE = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        find(0, new int[emoticons.length], users, emoticons);
        
        return new int[]{MAX_PLUS, MAX_PRICE};
    }
    
    private void find(int index, int[] discounts, int[][] users, int[] emoticons) {
        if(index == emoticons.length) {
            int plus = 0; 
            int price = 0;
            
            for(int[] user : users) {
                int userDiscount = user[0];
                int userMax = user[1];
                
                int sum = 0;
                
                for(int i = 0; i < emoticons.length; i++) {
                    if(discounts[i] >= userDiscount) {
                        sum += emoticons[i]/100*(100-discounts[i]);
                    }
                }
                if (sum>=userMax)plus++;
                else price+=sum;
            }
            if (plus>MAX_PLUS){
            MAX_PLUS = plus;
            MAX_PRICE = price;
            } else if (plus == MAX_PLUS){
                MAX_PRICE = Math.max(MAX_PRICE,price);
            }
            return;
        }
        
        for (int i = 0; i < 4; i++){
            discounts[index] = PERCENTS[i];
            find(index+1, discounts, users, emoticons);
        }
    }
}