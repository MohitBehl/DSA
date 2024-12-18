import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    HashMap<String,String> map = new HashMap<>();

    for(int i = 0 ; i < n ; i++){
        map.put(scn.next(),scn.next());
    }

    HashMap<String,Integer> ans = solve(map);
    for(String emp : ans.keySet()){
        System.out.println(emp+" "+ans.get(emp));
    }
  }

  public static HashMap<String,Integer> solve(HashMap<String,String> map){
    String ceo = "";

    HashMap<String,HashSet<Strig>> tree = new HashMap<>();
    for(String emp : map.keySet()){
        String manager = map.get(emp);

        if(emp == manager){
            ceo = emp;
        }else{
            HashSet<String> empList = tree.get(manager);
            if(empList == null){
                empList = new HashSet<>();
                empList.add(emp);
                tree.put(manager,empList);
            }else{
                empList.add(emp);
            }
        }
    }
    HashMap<String,Integer> ans = new HashMap<>();
    return changeAndRet(tree, ceo, ans);
  }

  public static int changeAndRet(HashMap<String,HashSet<String>> tree,String manager,HashMap<String,Integer> ans){
    HashSet<String> empList = tree.get(manager);
    if(empList == null){
        ans.add(manager,0);
        return 0;
    }

    int size = 0;
    for(String emp : empList){
        size += changeAndRet(tree, emp, ans);
    }
    ans.put(manager, size);
    return size+1;
  }
}
