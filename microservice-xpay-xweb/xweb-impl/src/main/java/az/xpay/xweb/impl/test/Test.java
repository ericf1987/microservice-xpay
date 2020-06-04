package az.xpay.xweb.impl.test;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/19 11:09
 */
public class Test {

    public <T, R> int convert(List<T> l, Map<String, R> map){
        return 0;
    }


    public void test1(){


        Random random = new Random();
        int r1 = random.nextInt(1000);
        System.out.println(r1);
        int r2 = random.nextInt(6500) - 1500;
        System.out.println(r2);

    }

    public static void main(String[] args) {
        Test t = new Test();

        t.test1();
    }

}
