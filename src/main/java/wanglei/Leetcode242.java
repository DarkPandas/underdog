package wanglei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanglei
 * @version 1.0
 * @date 2021-01-10 11:53 上午
 */
public class Leetcode242 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */

    public static void main(String[] args) {
        isAnagram();
    }

    public static boolean isAnagram() {
        return violent("aacc", "ccac");
    }

    private static boolean violent(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c)){
                characterIntegerMap.put(c, characterIntegerMap.get(c)+1);
            }else {
                characterIntegerMap.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < s.length(); j++){
            char c = t.charAt(j);
            if (characterIntegerMap.containsKey(c)){
                Integer integer = characterIntegerMap.get(c);
                integer --;
                if (integer < 0){
                    return false;
                }
                characterIntegerMap.put(c, integer);
            }else {
                return false;
            }
        }
        return true;
    }

    private static boolean sortFirstAndCompare(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
