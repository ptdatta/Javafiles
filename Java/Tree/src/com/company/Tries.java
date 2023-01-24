package com.company;

import javax.print.attribute.standard.Sides;
import java.util.ArrayList;
import java.util.List;

public class Tries {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("pqrs");
        list.add("pprt");
        list.add("psst");
        list.add("qqrs");
        list.add("pqrs");
        Trie trie=new Trie();
        list.forEach(trie::insert);
        System.out.println(trie.query("pqrs"));
        System.out.println(trie.query("abs"));
        trie.delete("psst");
        trie.update("pqrs","psst");
        System.out.println(trie.query("psst"));
        System.out.println(trie.query("pqrs"));
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        this.root=new TrieNode();
    }

    public int query(String s){
        TrieNode current=root;
      for(int i=0;i<s.length();i++){
          if(current==null){
              return 0;
          }
          current=current.next(s.charAt(i));
      }
      return current.terminating;
    }

    public void insert(String s){
        TrieNode current=root;
        for(int i=0;i<s.length();i++){
            if(current.trieNodes[s.charAt(i)-'a']==null){
                current.trieNodes[s.charAt(i)-'a']=new TrieNode();
            }
            current=current.next(s.charAt(i));
        }
        current.terminating++;
    }

    public void delete(String s){
        TrieNode current=root;
        for(int i=0;i<s.length();i++){
            if(current==null){
                return;
            }
            current=current.next(s.charAt(i));
        }
        if(current.terminating!=0){
            current.terminating--;
        }else{
            throw new RuntimeException("String not exist");
        }

    }
    public  void update(String old,String newString){
        delete(old);
        insert(newString);
    }
}
class TrieNode{
    int terminating;
    TrieNode[] trieNodes=new TrieNode[26];

    public TrieNode next(char c){
        return trieNodes[c-'a'];
    }

}