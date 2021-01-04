package wanglei;

public class Leetcode633 {

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     */

    /**
     * 1. c 小于0 返回false
     * 2. 求c的平方根 为最大值
     * 3. 从0开始
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0){
            return false;
        }
        int rightIndex = (int) Math.sqrt(c);
        int leftIndex = 0;
        while (leftIndex <= rightIndex){
            int sum = leftIndex * leftIndex + rightIndex * rightIndex;
            if (sum < c){
                leftIndex ++ ;
            }else if (sum > c){
                rightIndex -- ;
            }else {
                return true;
            }
        }
        return false;
    }
}
