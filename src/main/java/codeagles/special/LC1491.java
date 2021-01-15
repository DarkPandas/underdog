package codeagles.special;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2021/1/15
 * Time: 下午3:15
 * <p>
 * Description:
 */
public class LC1491 {

    public static void main(String[] args) {
        LC1491 lc = new LC1491();
        int[] salary = {4000,3000,1000,2000};
        double average = lc.average(salary);
        System.out.println(average);

    }

    public double average(int[] salary) {
        if (salary.length <=2) {return 0;}
        int min = salary[0];
        int max = 0;
        int sum = 0;
        for (int i : salary) {
            min = min < i ? min : i;
            max = max > i ? max :i;
            sum += i;
        }
        return  (sum - min - max)*1.0/(salary.length-2);
    }
}
