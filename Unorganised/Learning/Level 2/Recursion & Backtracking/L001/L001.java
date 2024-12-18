import java.util.Scanner;

public class L001{
    // (5,9) : 5 6 7 8 9   
    public static void printIncreasing(int a,int b){
        if(a > b){
            System.out.println(".");
            return;
        }

        System.out.print(a+" ");
        printIncreasing(a+1,b);
    }
    // (5,9) : 9 8 7 6 5
    public static void printDecreasing(int a,int b){
        if(a > b){
            System.out.println(".");
            return;
        }

        System.out.print(b+" ");
        printDecreasing(a,b-1);
    }
    // (5,9) : 5 6 7 8 9 9 8 7 6 5
    public static void printIncreasingDecreasing(int a,int b){
        if(a > b){
            return;
        }

        System.out.print(a+" ");
        printIncreasingDecreasing(a+1,b);
        System.out.print(a+" ");
    }
    // (5,9) : 5 7 9 8 6
    public static void printOddEven(int a,int b){
        if(a > b){
            
            return;
        }

        if(a%2 == 1) System.out.print(a+" ");
        printOddEven(a+1,b);
        if(a%2 == 0) System.out.print(a+" ");
    }
    // n = 5
    public static int printTreePath(int n){
        if(n == 1 || n == 0){
            System.out.println("Base : " + n);
            return n;
        }

        int ans = 0;

        System.out.println("Pre : " + n);
        ans += printTreePath(n-1);
        System.out.println("In : "+ n);
        ans += printTreePath(n-2);
        System.out.println("Post : "+ n);

        return ans;
    }
    public static void main(String args[]){
        printIncreasing(5,9);
        printDecreasing(5,9);
        printIncreasingDecreasing(5,9);
        System.out.println(".");
        printOddEven(5,9);
        System.out.println(".");
        printTreePath(5);
    }
}