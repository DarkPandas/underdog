package fkk;

import java.util.HashMap;

/**
 * Author: karl
 * Date: 2021/3/13 下午10:26
 * <p>
 * Desc:
 */
public class LC03 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }

        return max;
    }
}
