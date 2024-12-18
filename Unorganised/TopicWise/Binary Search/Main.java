import java.util.*;
public class Main {
    public static int binarySearch(int nums[],int tar){
        int left = 0 , right = nums.length-1;
        //(left,right) : initial search space

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] < target){ // move to right search space
                left = mid+1;
            }else if(nums[mid] > target){ // move to left search space
                right = mid-1;
            }else { // element found
                return mid;
            }
        }
        return -1;
    }
    public static int sqrtxDirect(int x){
        if(x < 0){
            return x;
        }
        int lans = (int)Math.pow(Math.E,0.5*Math.log(x));
        int rans = lans+1;

        return (long)rans*rans > x ? lans : rans;
    }
    public static int sqrtxBinarySearch(int x){
        if(x < 2){
            return x;
        }

        int left = 2 , right = x/2;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(mid*mid > x){
                right = mid-1;
            }else if(mid*mid < x){
                left = mid+1;
            }else{
                return mid;
            }
        }

        return right;
    }
    public int guessNumber(int n) {
        int left = 1 , right = n;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            int res = guess(mid);
            
            if(res == 0){
                return mid;
            }else if(res == -1){
                right = mid-1;
            }else if(res == 1){
                left = mid+1;
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]){

    }    
}
