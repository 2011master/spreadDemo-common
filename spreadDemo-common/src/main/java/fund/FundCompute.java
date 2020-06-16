package fund;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
* @desc   基金计算
* @author kanggw
* @datetime 2020/6/15,9:27 下午
*/
public class FundCompute {


    /**
     *
     * @param oldNetValue 昨日复权净值
     * @param newNetValue 今日复权净值
     * @param copies 份数
     * @return 收益
     */
    public static BigDecimal computeEarnings(BigDecimal oldNetValue,BigDecimal newNetValue,BigDecimal copies) {

        return newNetValue.subtract(oldNetValue).multiply(copies);
    }

    /**
     * 计算涨幅
     * @param oldNetValue 昨日复权净值
     * @param newNetValue 今日复权净值
     * @return 涨幅
     */
    public static String computeGains(BigDecimal oldNetValue,BigDecimal newNetValue) {

        return newNetValue.subtract(oldNetValue).divide(oldNetValue,6,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString() + "%";
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入昨日复权净值：");
        BigDecimal oldNetValue = new BigDecimal(br.readLine());

        System.out.println("请输入今日复权净值：");
        BigDecimal newNetValue = new BigDecimal(br.readLine());

        System.out.println("请输入总份数：");
        BigDecimal copies = new BigDecimal(br.readLine());

        final String gains = computeGains(oldNetValue, newNetValue);

        System.out.println("涨幅为：" + gains);

        final BigDecimal earnings = computeEarnings(oldNetValue, newNetValue, copies);

        System.out.println("收益：" + earnings);
    }
}
