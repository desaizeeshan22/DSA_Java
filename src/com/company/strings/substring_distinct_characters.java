package com.company.strings;

import java.util.HashMap;
import java.util.Map;

public class substring_distinct_characters {
    public boolean is_distinct(String str,int i,int j){
        char[]str_arr=str.toCharArray();
        Map<Character,Integer> hashMap=new HashMap<Character,Integer>();
        for(;i<=j;i++){
            if(hashMap.containsKey(str_arr[i])){
                return false;
            }
            else{
                hashMap.put(str_arr[i],1);
            }
        }
        return true;
    }
    public  int length_longest_distinct_substrings(String str){
        if (str.length()==0){
            return 0;
        }
            int res=1;
            for(int i=0;i<str.length();i++){
                for(int j=i;j<str.length();j++){
                    if(is_distinct(str,i,j)){
                        res=Math.max(res,j-i+1);
                    }
                }
            }
            return res;

    }
    public int optimized_longest_distinct_substring(String str){
        if (str.length()==0){
            return 0;
        }
        int res=1;
        for (int i=0;i<str.length();i++){
            Map<Character,Integer>hashMap=new HashMap<Character,Integer>();
            for(int j=i;j<str.length();j++){
                if(hashMap.containsKey(str.charAt(j))){
                    res=Math.max(res,j-i);
                    break;
                }
                else{
                    hashMap.put(str.charAt(j),1);
                }
            }
            hashMap.clear();
        }
        return res;
    }
    public int most_optimum_subs(String s){
        if (s.length()==0){
            return 0;
        }
        int res=1;
        int i=0;
        Map<Character,Integer>hashMap=new HashMap<Character,Integer>();
        for(int j=0;j<s.length();j++){
            if(hashMap.containsKey(s.charAt(j))){
                i=Math.max(i,hashMap.get(s.charAt(j))+1);
            }
            res=Math.max(res,j-i+1);
            hashMap.put(s.charAt(j),j);
        }
        return res;
    }

}
