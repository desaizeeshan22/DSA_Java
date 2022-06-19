package com.company.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class String_rotation {
    public int[] KMP_array(String pattern) {
        int[] LPS_array = new int[pattern.length()];
        Arrays.fill(LPS_array, 0);
        int i = 0;
        int len = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len += 1;
                LPS_array[i] = len;
                i += 1;
            } else {
                if (len == 0) {
                    LPS_array[i] = len;
                    i += 1;
                } else {
                    len = LPS_array[len - 1];
                }
            }

        }
        return LPS_array;
    }
//        public boolean is_rotation(String s1,String s2){
//            if(s1.length()!=s2.length()){
//                return false;
//            }
//            int[]LPS_array=KMP_array(s2);
//
//        }
}

