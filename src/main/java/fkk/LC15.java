package fkk;

import fkk.support.SortManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 https://leetcode-cn.com/problems/3sum/
 */
public class LC15 {


    /**
     * 三元求和转换成二元求和
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int size = nums.length;

        if (size < 3) {
            return result;
        }
        //排序
        SortManager.insertionSort(nums);

        Arrays.sort(nums);

        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int dst = -nums[i];
            int b = size - 1;

            for (int a = i + 1; a < size; a++) {
                if (a > i + 1 && nums[a] == nums[a - 1]) {
                    continue;
                }

                while (a < b && nums[a] + nums[b] > dst) {
                    b--;
                }

                if (a == b) {
                    break;
                }

                if (nums[a] + nums[b] == dst) {
                    List<Integer> dstList = new ArrayList<>();
                    dstList.add(nums[i]);
                    dstList.add(nums[a]);
                    dstList.add(nums[b]);
                    result.add(dstList);
                }
            }
        }
        return result;
    }


}
