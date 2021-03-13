package codeagles.special.arrays;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2021/1/15
 * Time: 下午4:06
 * <p>
 * Description:
 */
public class LC75 {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        LC75 lc= new LC75();
        lc.sortColors(nums);
    }

    /**
     * 思想：循环不变量
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i = 0, j = 0, k=nums.length-1 ;j<=k; ++j) {
            if(nums[j] == 0){
                nums[j] = nums[i];
                nums[i++] = 0;
            }else if(nums[j] == 2) {
                nums[j--] = nums[k];
                nums[k--] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
