package wanglei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wanglei
 * @version 1.0
 * @date 2020-12-09 9:17 下午
 */
public class Leetcode15 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     */

    public static void main(String[] args) {

        int [] data = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = violentSolution(data);
        System.out.println("data:" + lists);
    }

    /**
     * 直接三重循环暴力求解，但存在问题，会返回重复的元素，返回重复元素的原因是数组为排序，存在前面小中间大后面小的情况，因此需要首先排序
     * 1. 数组排序
     * 2. 因为 a + b + c == 0 ，所以若此时 b 向右变大，同时需要满足 c 变小才可以存在等式，而此时 c 向左变小，因此b向右循环与c向左循环可以同时进行
     * 3. 若存在相邻的数字相同的情况，需要将下标跳至不相同的元素所在小标
     */
    private static List<List<Integer>> violentSolution(int[] arrays){
        Arrays.sort(arrays);
        List<List<Integer>> result = new ArrayList<>();
        if (arrays == null || arrays.length < 3){
            return null;
        }
        if (arrays.length == 3){
            int target = arrays[0] + arrays[1] + arrays[2];
            if (target == 0){
                List<Integer> item = new ArrayList<>();
                item.add(arrays[0]);
                item.add(arrays[1]);
                item.add(arrays[2]);
                result.add(item);
                return result;
            }else {
                return null;
            }
        }
        int length = arrays.length;
        for (int startIndex = 0; startIndex < length; startIndex++){
            if (startIndex > 0 && arrays[startIndex] == arrays[startIndex - 1]) {
                continue;
            }
            int thirdIndex = length - 1;
            int target = -arrays[startIndex];
            for (int secondIndex = startIndex + 1; secondIndex < length; ++secondIndex) {

                if (secondIndex > startIndex + 1 && arrays[secondIndex] == arrays[secondIndex - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (secondIndex < thirdIndex && arrays[secondIndex] + arrays[thirdIndex] > target) {
                    --thirdIndex;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (secondIndex == thirdIndex) {
                    break;
                }
                if (arrays[secondIndex] + arrays[thirdIndex] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arrays[startIndex]);
                    list.add(arrays[secondIndex]);
                    list.add(arrays[thirdIndex]);
                    result.add(list);
                }
            }
        }
        return result;
    }

}
