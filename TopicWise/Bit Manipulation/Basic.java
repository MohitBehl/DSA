class Main{
    public static void main(String []args){
        // int n1 = 5; // 101 
        // int n2 = 3; // 011

        // System.out.println("bitwise or : "+(n1 | n2)); // 7 : 111
        // System.out.println("bitwise and : "+(n1 & n2)); // 1 : 001
        // System.out.println("bitwise xor : "+(n1 ^ n2)); // 7 : 111
        // System.out.println("negation : "+(~n1));

        // System.out.println(n1 >> 1); // 10
        // System.out.println(n1 >> 2); // 1

        // System.out.println(-101 >> 2);
        // System.out.println(101 >> 2);
        // System.out.println(-17 >> 1);

        // System.out.println(n1 << 1);
        System.out.println(isEven(5));
        System.out.println(numberOfSetBits1(5));
        System.out.println(numberOfSetBits2(5));
        System.out.println(numberOfFlipsRequiredToMakeEqualNumber(5,3));
        System.out.println(firstSetBitFromLeft(5));
        System.out.println(firstSetBitFromRight(5));
        System.out.println(isKthBitSet(5,6));
        System.out.println(isKthBitUnSet(5,6));
        System.out.println(flipKthBit(5,1));
    }

    public static boolean isEven(int num){
        return (num & 1) == 0;
    }
    public static int numberOfSetBits1(int num){
        int count = 0;
        for(int pos = 0 ; pos <= 31 ; pos++){
            int mask = 1 << pos;
            if((num&mask) != 0)
                count++;
        }
        return count;
    }
    public static int numberOfSetBits2(int num){
        int count = 0;
        while(num != 0){
            num &= (num-1);
            count++;
        }
        return count;
    }
    public static int numberOfFlipsRequiredToMakeEqualNumber(int num1,int num2){
        int count = 0;
        for(int pos = 0 ; pos <= 31 ; pos++){
            int mask = (1 << pos);
            boolean isBitSetInNum1 = (num1 & mask) == 0;
            boolean isBitSetInNum2 = (num2 & mask) == 0;
            if(isBitSetInNum1 ^ isBitSetInNum2){
                count++;
            }
        }
        return count;
    }
    public static int firstSetBitFromLeft(int num){
        int pos = 31;
        while(pos >= 0){
            int mask = (1 << pos);
            if((mask & num) != 0) return pos;
            pos--;
        }
        return -1;
    }
    public static int firstSetBitFromRight(int num){
        int pos = 0;
        while(pos <= 31){
            int mask = (1 << pos);
            if((mask & num) != 0) return pos;
            pos++;
        }
        return 32;
    }
    public static boolean isKthBitSet(int num,int k){
        int mask = (1 << k);
        if((num & mask) != 0) return true;
        else return false;
    }
    public static boolean isKthBitUnSet(int num,int k){
        int mask = (1 << k);
        if((num & mask) == 0) return true;
        else return false;
    }
    public static int flipKthBit(int num,int k){
        int mask = (1 << k);
        int ans = (num ^ mask);
        return ans;
    }
} 