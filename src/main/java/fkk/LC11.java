package fkk;

import fkk.support.Log;

/**
 * Author: karl
 * Date: 2021/3/29 下午9:17
 * <p>
 * Desc:
 */
public class LC11 {

    /**
     * 好用的双指针
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left != right) {
            int a = height[left];
            int b = height[right];
            maxArea = Math.max(Math.min(a, b) * (right - left), maxArea);

            if (a > b) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        LC11 lc11 = new LC11();
        int maxArea = lc11.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
        Log.w(maxArea);
    }
}
