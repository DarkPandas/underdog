package codeagles.special.arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2021/1/15
 * Time: 下午3:36
 * <p>
 * Description:
 */
public class LC1512 {
    public static void main(String[] args) {
        LC1512 lc = new LC1512();
        int[] salary = {1,3,1,2,1};
        int i = lc.numIdenticalPairs(salary);
        System.out.println(i);
    }

    /**
     * 通过组合计数方式，结合排列组合Cn算出结果
     */
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[104];//数据范围容错边界，至少一位
        for (int i : nums) {
            ++count[i];
        }
        int res = 0;
        for (int i : count) {
            res += i*(i-1)/2; //排列组合公式
        }
        return  res;
    }
}
