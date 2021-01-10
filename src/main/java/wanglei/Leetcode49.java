package wanglei;

import java.util.*;

/**
 * @author wanglei
 * @version 1.0
 * @date 2021-01-10 12:09 下午
 */
public class Leetcode49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        return solution(strs);
    }

    /**
     * 很明显 该题目为 242 的进阶，由242可知，我们可通过将字符串对应数组排序进行比较，因此我们可以以该思路为基础，
     * 将所有排序后的数组转成字符串作为哈希表的key值，列表作为值
     * @param strs
     * @return
     */
    private List<List<String>> solution(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }
}
