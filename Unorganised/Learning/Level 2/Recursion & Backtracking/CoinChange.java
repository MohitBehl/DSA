public class CoinChange {
    // coin change combination 1: find ways to pay amt when mutiple use of coin is not allowed
    public static void coinChangeCombination1(int coins[],int idx,int amtsf,int tamt,String ans){
        if(amtsf == tamt){
            System.out.println(ans+".");
            return;
        }
        if(amtsf > tamt || idx == coins.length) return;
        coinChangeCombination1(coins, idx+1, amtsf+coins[idx], tamt, ans+coins[idx]+"-"); // include
        coinChangeCombination1(coins, idx+1, amtsf, tamt, ans); // exclude
    }
    // coin change combination 2: find ways to pay amt when mutiple use of coin is allowed
    public static void coinChangeCombination2(int[]coins,int idx,int amtsf,int tamt,String ans){
        if(amtsf == tamt){
            System.out.println(ans+".");
            return;
        }
        if(amtsf > tamt || idx == coins.length) return;
        
        int remAmt = tamt - amtsf;
        for(int i = remAmt/coins[idx] ; i >= 0 ; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < i ; j++){
                sb.append(coins[idx]+"-");
            }
            coinChangeCombination2(coins, idx+1, amtsf+(coins[idx]*i), tamt, ans+sb.toString());
        }
    }
    public static void main(String[] args) {
        
    }
}
