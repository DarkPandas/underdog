package fkk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: karl
 * Date: 2021/1/6 下午10:04
 * <p>
 * Desc: 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 */
public class LC49 {

    /**
     * 1. 字符串转换成char然后进行排序
     * 2. 根据hashmap key的唯一性来判断
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String source : strs) {
            char[] chars = source.toCharArray();
            Arrays.sort(chars);
            String dst = new String(chars);
            List<String> list = hashMap.getOrDefault(dst, new ArrayList<>());
            list.add(dst);
            hashMap.put(dst, list);
        }
        return new ArrayList<>(hashMap.values());
    }

    /**
     * 1. 创建一个长度26的数组，代表小写字母a-z
     * 2. 对每一个字符串进行拆解，计算对应字母出现的次数，存入字母数组
     * 3. 将字母数组中出现次数大于0的字母取出来+字母次数合成字符串，作为map的key
     * 4. 找到map中相同key的字符串为一组
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String source : strs) {
            int[] letters = new int[26];
            char[] chars = source.toCharArray();
            for (char ch : chars) {
                letters[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] > 0) {
                    sb.append((char) ('a' + i));
                    sb.append(letters[i]);
                }
            }
            String key = sb.toString();
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            list.add(source);
            hashMap.put(key, list);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        List<List<String>> dataList = groupAnagrams2(new String[]{"ddddddddddg", "dgggggggggg"});
        String dst = toString(dataList);
        System.out.println(dst);
        System.out.println("\n");

        List<List<String>> dataList2 = groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        String dst2 = toString(dataList2);
        System.out.println(dst2);

    }

    private static String toString(List<List<String>> dataList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (List<String> list : dataList) {
            sb.append("[ ");
            for (String dst : list) {
                sb.append(dst);
                sb.append(" ");
            }
            sb.append(" ] ");
        }
        sb.append(" ]");
        return sb.toString();
    }

}
