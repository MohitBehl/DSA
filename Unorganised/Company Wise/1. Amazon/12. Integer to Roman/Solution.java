class Solution {
    static int[] valInt = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] valStr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            while(num >= valInt[idx]){
                num -= valInt[idx];
                sb.append(valStr[idx]);
            }
            idx++;
        }
        
        return sb.toString();
    }
}