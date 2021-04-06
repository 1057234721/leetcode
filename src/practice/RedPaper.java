package practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20210406
 * To change this template use File | Settings | File Templates.
 * 二倍均值法
 * 线段切割法
 */
public class RedPaper {

    //二倍均值法

    public static List<Integer> ListDivideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList();

//为了使用random.nextInt(Integer)方法不得不先把红包金额放大100倍，最后在main函数里面再除以100

//这样就可以保证每个人抢到的金额都可以精确到小数点后两位

        Integer restAmount = totalAmount * 100;

        Integer restPeopleNum = totalPeopleNum;

        Random random = new Random();

        for (int i = 0; i < totalPeopleNum - 1; i++) {
// 随机范围：[1，剩余人均金额的两倍)，左闭右开

            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;

            restAmount -= amount;

            restPeopleNum--;

            amountList.add(amount);

        }

        amountList.add(restAmount);

        return amountList;

    }






    //线段分割法

    private static List divide(double money, int n) {
//验证参数合理校验

//为了使用random.nextInt(Integer)方法不得不先把红包金额放大100倍，最后在main函数里面再除以100

//这样就可以保证每个人抢到的金额都可以精确到小数点后两位

        int fen = (int) (money * 100);

        if (fen < n || n < 1) {
            System.out.println("红包个数必须大于0，并且最小红包不少于1分");

        }

      List<Integer>  boards = new ArrayList<Integer>();

        boards.add(0);

        boards.add(fen);

//红包个数和板砖个数的关系

        while (boards.size() <= n) {
            int index = new Random().nextInt(fen - 1) + 1;

            if (boards.contains(index)) {
//保证板子的位置不相同

                continue;

            }

            boards.add(index);

        }

//计算每个红包的金额，将两个板子之间的钱加起来

        Collections.sort(boards);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < boards.size() - 1; i++) {
            Integer e = boards.get(i + 1) - boards.get(i);
            list.add(e);

        }

        return list;

    }
    public static void main(String[] args) {
// ListaccountList = divideRedPackage(50, 1000);

       // List<Integer> accountList = divide(50, 10);

        List<Integer> accountList = ListDivideRedPackage(50, 10);

        BigDecimal count = new BigDecimal(0);

        for (Integer amount : accountList) {
//将抢到的金额再除以100进行还原

            BigDecimal tmpcount = new BigDecimal(amount).divide(new BigDecimal(100));

            count = count.add(tmpcount);

            System.out.println("抢到金额：" + tmpcount);

        }

        System.out.println("total=" + count);

    }
}
