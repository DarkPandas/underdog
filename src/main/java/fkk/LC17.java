package fkk;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: karl
 * Date: 2021/3/29 下午9:39
 * <p>
 * Desc: 电话号码的字母组合
 */
public class LC17 {

    /**
     * 解题思路：回溯+递归
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations,
                           Map<Character, String> phoneMap,
                           String digits,
                           int step,
                           StringBuffer stringBuffer) {
        if (step == digits.length()) {
            combinations.add(stringBuffer.toString());
        } else {
            char ch = digits.charAt(step);
            String letters = phoneMap.get(ch);
            for (int i = 0; i < letters.length(); i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, step + 1, stringBuffer);
                //把已经添加的删除，追加下一个
                stringBuffer.deleteCharAt(step);
            }
        }

    }


}
