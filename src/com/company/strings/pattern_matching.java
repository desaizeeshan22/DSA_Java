package com.company.strings;

public class pattern_matching {
    public void pattern_occurence(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int s_len = s_arr.length;
        int p_len = p_arr.length;
        for (int i = 0; i < s_len - p_len + 1; i++) {
            int j = 0;
            for (; j < p_len; j++) {
                if (p_arr[j] != s_arr[i + j]) {
                    break;
                }
            }
            if (j == p_len) {
                System.out.println(i);
            }

        }
    }

    public void distinct_char_pattern(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        int s_len = s_arr.length;
        int p_len = p_arr.length;
        for (int i = 0; i < s_len - p_len + 1; i++) {
            int j = 0;
            for (; j < p_len; j++) {
                if (p_arr[j] != s_arr[i + j]) {
                    break;
                }
            }
            if (j == p_len) {
                System.out.println(i);
            }
            if (j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }

    }
}


