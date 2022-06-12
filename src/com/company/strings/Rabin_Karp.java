package com.company.strings;

public class Rabin_Karp {
    void rabin_karp(String s,String p){
//        rolling hash for weighted hash : hash(i+1)=(d*(hash(i)-text[i]*d**m-1)+text[i+m])%q
//        m-length of the pattern,d- base for weighted addition
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int s_len = s_arr.length;
        int p_len = p_arr.length;
//        precalculating the term (d**m-1)%q
        int h=1;
        int q=2003;
        int d=10;
        for(int i=0;i<p_len-1;i++) {
            h=(h*d)%q;
        }
        int hash_p=0;
        int t=0;
//        Calculating the hash function for the pattern p and the hash function for the pattern of size p_len
        for(int i=0;i<p_len;i++){
            hash_p=(hash_p*d+p_arr[i])%q;
            t=(t*d+s_arr[i])%q;
        }
        for(int i=0;i<=s_len-p_len;i++){
            boolean flag=true;
            if(hash_p==t){
                for(int j=0;j<p_len;j++) {
                    if(s_arr[i+j]!=p_arr[j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(i);
                }
                }
            if(i<s_len-p_len) {
             t=(d*(t-h*s_arr[i])+s_arr[i+p_len])%q;
             if(t<0) {
                 t += q;
             }
            }
            }
        }
        }
