package fkk;

import fkk.support.Log;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author: karl
 * Date: 2021/1/7 下午10:00
 * <p>
 * Desc:
 */
public class LC242 {


    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = hashMap.getOrDefault(ch, 0);
            count++;
            hashMap.put(ch, count);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer count = hashMap.getOrDefault(ch, 0);
            if (count == 0) {
                return false;
            }
            hashMap.put(ch, count - 1);
        }
        return true;
    }


    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int count = --letters[t.charAt(i) - 'a'];
            if (count < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 排序后比较
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }


    public static void main(String[] args) {
        Log.n("M1: {anagram, nagaram} = " + isAnagram("anagram", "nagaram"));
        Log.n("M1: {a, b} = " + isAnagram("a", "b"));
        Log.n("M1: {'', ''} = " + isAnagram("", ""));
        Log.n("");
        Log.n("M2: {anagram, nagaram} = " + isAnagram2("anagram", "nagaram"));
        Log.n("M2: {a, b} = " + isAnagram2("a", "b"));
        Log.n("M2: {'', ''} = " + isAnagram2("", ""));
        Log.n("");
        Log.n("M3: {anagram, nagaram} = " + isAnagram3("anagram", "nagaram"));
        Log.n("M3: {a, b} = " + isAnagram3("a", "b"));
        Log.n("M3: {'', ''} = " + isAnagram3("", ""));
    }
}
