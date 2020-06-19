package az.xpay.xweb.impl.test.guava.common.base;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/15 19:47
 */
public class CaseFormatTest {

    public static void test1(){
        String target = "project_school_class";
        String src1 = "user_name";

        CaseFormat lowerCamel = CaseFormat.LOWER_UNDERSCORE;

        //定义 下划线转化为驼峰命名
        Converter<String, String> converter = lowerCamel.converterTo(CaseFormat.LOWER_CAMEL);
        String result = converter.convert(src1);
        System.out.println(result);

    }

    public static void test2(){
        char c = 'A';
        System.out.println((char)(c ^ 32));
    }


    public static void main(String[] args) {
        test2();
    }

}
