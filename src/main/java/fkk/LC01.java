package fkk;

import java.util.HashMap;

/**
 * Author: karl
 * Date: 2021/1/6 下午9:45
 * <p>
 * Desc: 两数之和
 */
public class LC01 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int dst = target- nums[i];
            if (map.containsKey(dst)){
                return new int[]{i,map.get(dst)};
            }

            map.put(nums[i],i);

        }

        return new int[0];
    }
}
