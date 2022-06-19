package com.company.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//An LPS array contains the length of the longest proper prefix which is also the suffix of substrings uptill every index of the string
//upto the substring length of a maximum of string_lenght-1 since proper  prefix means the entire string cannot be used
public class KMP {
    //    function to calculate the length of the proper prefix which is also the suffix
    public int naive_LPS(String s, int len_string) {
        for (int len = len_string - 1; len > 0; len--) { //check from the length len_string -1 aka the proper prefix which cannot
            boolean flag = true;                                   // include the whole string
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != s.charAt(len_string - len + i)) {
                    flag = false;
                }
            }
            if (flag == true) {
                return len;
            }
        }
        return 0;
    }

    public int[] naive_LPS_arr(String s) {
        int[] LPS_arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            LPS_arr[i] = naive_LPS(s, i + 1);
        }
        return LPS_arr;
    }

    public int[] optimum_LPS_arr(String s) {
        int[] LPS_arr = new int[s.length()];
        Arrays.fill(LPS_arr, 0);
        int len = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len += 1;
                LPS_arr[i] = len;
                i += 1;
            } else {
                if (len == 0) {
                    LPS_arr[i] = 0;
                    i += 1;
                } else {
                    len = LPS_arr[len - 1];
                }
            }
        }
        return LPS_arr;
    }

    public List<Integer> KMP_whole(String s, String p) {
        int i = 0;
        int j = 0;
        int[] LPS = optimum_LPS_arr(s);
        List<Integer> indices = new ArrayList<Integer>();
        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i += 1;
                j += 1;
            }
            if (j == p.length()) {
                indices.add(i - j);
                j = LPS[j - 1];
            }
            if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                if (j == 0) {
                    i += 1;
                } else {
                    j = LPS[j - 1];
                }
            }
        }
        return indices;
    }
}



