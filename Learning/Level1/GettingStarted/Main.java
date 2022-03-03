public class Main{
    public static void printZ(){
        System.out.println("*****");
        System.out.println("   * ");
        System.out.println("  *  ");
        System.out.println(" *   ");
        System.out.println("*****");
    }
    
    public static void gradingSystem(){
        Scanner scn = new Scanner(System.in);
        int marks = scn.nextInt();

        if(marks > 90){
            System.out.println("excellent");
        }else if(marks > 80){
            System.out.println("good");
        }else if(marks > 70){
            System.out.println("fair");
        }else if(marks > 60){
            System.out.println("meets expectations");
        }else{
            System.out.println("below par");
        }
    }

    public static void isANumberPrime(){
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-- > 0){
            int n = scn.nextInt();
            boolean flag = true;
            for(int fac = 2 ; fac * fac <= n ; fac++){
                if(n%fac == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
        }
    }

    public static void printFibonacciNumbersTillN(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int first = 0 , second = 1;
        for(int i = 0 ; i < n ; i++){
            System.out.println(first);

            int third = first + second;

            first = second;
            second = third;
        }
    }

    public static void countDigitsInANumber(){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int count = 0;
        while(num != 0){
            num = num / 10;
            count++;
        }

        System.out.println(count);
    }

    public static void digitsOfANumber(){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int tnum = num;
        int div = 1;
        while(tnum > 9){
            div = div * 10;
            tnum = tnum / 10;
        }

        while(div != 0){
            int digit = num / div;
            num = num % div;
            div = div / 10;
            System.out.println(digit);
        }
    }

    public static void reverseANumber(){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        while(num != 0){
            int digit = num % 10;
            num = num / 10;

            System.out.println(digit);
        }
    }

    public static void rotateANumber(){
        Scanner scn = new Scanner(System.in);


    }
    public static void main(String args[]){
        
    }
}