import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        Stack<Integer> eval = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        for(int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);

            if(ch == '-' || ch == '+' || ch == '/' || ch == '*'){
                evalHelper(eval,ch);
                prefixHelper(prefix,ch);
                infixHelper(infix,ch);
            }else if('0' <= ch && ch <= '9'){
                eval.push(ch-'0');
                prefix.push(ch+"");
                infix.push(ch+"");
            }
        }

        System.out.println(eval.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static void evalHelper(Stack<Integer> eval,char op){
        int v2 = eval.pop() , v1 = eval.pop();

        if(op == '+') eval.push(v1 + v2);
        if(op == '-') eval.push(v1 - v2);
        if(op == '/') eval.push(v1 / v2);
        if(op == '*') eval.push(v1 * v2);
    }
    public static void prefixHelper(Stack<String> prefix,char op){
        String v2 = prefix.pop() , v1 = prefix.pop();
        String res = op+v1+v2;
        prefix.push(res);
    }
    public static void infixHelper(Stack<String> infix,char op){
        String v2 = infix.pop() , v1 = infix.pop();
        String res = "("+v1+op+v2+")";
        infix.push(res);
    }
}