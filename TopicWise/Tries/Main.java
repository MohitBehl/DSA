import java.util.*;
public class Main{
    static class Node{
        char ch;
        boolean isEnd;
        HashMap<Character,Node> children;

        Node(char ch){
            this.ch = ch;
            children = new HashMap<>();   
            this.isEnd = false;
        }

        boolean hasChild(char childCh){
            return children.containsKey(childCh);
        }
        Node getChild(char childCh){
            return this.children.get(childCh);
        }
        Node addChild(char childCh){
            if(this.children.containsKey(childCh)){
                return this.children.get(childCh);
            }
            Node childNode = new Node(childCh);
            this.children.put(childCh,childNode);
            return childNode;
        }
        void markEndOfWord(){
            this.isEnd = true;
        }
        boolean isEndOfWord(){
            return this.isEnd;
        }
        void unmarkEndOfWord(){
            this.isEnd = false;
        }
    }
    static class Trie{
         Node root;

         Trie(){
            root = new Node('-');
         }

         void insert(String word){
            Node ptr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    ptr = ptr.addChild(ch);
                }
            }
            ptr.markEndOfWord();
         }

         boolean search(String word){
            Node ptr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    return false;
                }
            }
            return ptr.isEndOfWord();
         }

         boolean prefix(String word){
            Node ptr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    return false;
                }
            }
            return true;
         }

         void remove(String word){
            Node ptr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(ptr.hasChild(ch)){
                    ptr = ptr.getChild(ch);
                }else{
                    return;
                }
            }
            ptr.unmarkEndOfWord();
         }
    }

    public static void main(String args[]){
        Trie obj = new Trie();

        obj.insert("apple");
        obj.insert("bank");
        obj.insert("apples");
        obj.insert("ban");
        obj.insert("app");
        obj.insert("bat");
        obj.insert("zeee");
        obj.insert("omega");

        System.out.println(obj.search("app"));
        System.out.println(obj.search("ap"));
        System.out.println(obj.prefix("ap"));

    }
}