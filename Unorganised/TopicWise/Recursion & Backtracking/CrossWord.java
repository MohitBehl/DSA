import java.io.*;
import java.util.*;

class Main {

  public static void solution(char[][] arr, String[] words, int widx) {
    if(widx == words.length){
        print(arr);
        return;
    }
    String word = words[widx];
    for(int i = 0 ; i < arr.length ; i++){
        for(int j = 0 ; j < arr[0].length ; j++){
            if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
                if(canbePlacedH(arr,i,j,word)){
                    boolean vis[] = new boolean[word.length()];
                    placeH(arr,i,j,word,vis); // mark
                    solution(arr,words,widx+1);
                    unPlaceH(arr,i,j,vis); // unmark
                }
                
                if(canbePlacedV(arr,i,j,word)){
                    boolean vis[] = new boolean[word.length()];
                    placeV(arr,i,j,word,vis); // mark
                    solution(arr,words,widx+1);
                    unPlaceV(arr,i,j,vis); // unmark
                }
            }
        }
    }
  }
  public static void placeH(char[][] arr,int i,int j,String word,boolean vis[]){
        int idx = 0;
        while(idx < word.length()){
            if(arr[i][j+idx] == '-'){
                arr[i][j+idx] = word.charAt(idx);
                vis[idx] = true;
            }
            idx++;
        }
  }
  public static void placeV(char[][] arr,int i,int j,String word,boolean vis[]){
        int idx = 0;
        while(idx < word.length()){
            if(arr[i+idx][j] == '-'){
                arr[i+idx][j] = word.charAt(idx);
                vis[idx] = true;
            }
            idx++;
        }
  }
  public static void unPlaceH(char[][] arr,int i,int j,boolean vis[]){
        int idx = 0;
        while(idx < vis.length){
            if(vis[idx]){
                arr[i][j+idx] = '-';
            }
            idx++;
        }
  }
  public static void unPlaceV(char[][] arr,int i,int j,boolean vis[]){
        int idx = 0;
        while(idx < vis.length){
            if(vis[idx]){
                arr[i+idx][j] = '-';
            }
            idx++;
        }
  }
  public static boolean canbePlacedH(char[][] arr,int i,int j,String word){
        int idx = 0;
        while(idx < word.length()){
            if(j+idx < arr[0].length && (arr[i][j+idx] == '-' || arr[i][j+idx] == word.charAt(idx))){
                idx++;
            }else{
                return false;    
            }
        }
        if((j+idx == arr[0].length || arr[i][j+idx] == '+') && (j-1 == -1 || arr[i][j-1] == '+')){
            return true;
        }else{
            return false;
        }
  }
  
  public static boolean canbePlacedV(char[][] arr,int i,int j,String word){
    int idx = 0;
    while(idx < word.length()){
        if(i+idx < arr.length && (arr[i+idx][j] == '-' || arr[i+idx][j] == word.charAt(idx))){
            idx++;
        }else{
            return false;    
        }
    }
    if((i+idx == arr.length || arr[i+idx][j] == '+') && (i-1 == -1 || arr[i-1][j] == '+')){
        return true;
    }else{
        return false;
    }
  }
  
  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}