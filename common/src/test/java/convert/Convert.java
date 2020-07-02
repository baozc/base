package convert;

import java.util.ArrayList;
import java.util.List;

import cn.baozcc.util.BeanConvert;
import org.springframework.beans.BeanUtils;

/**
 * @author baozc
 * @date 2020/7/1 10:39 PM
 */
public class Convert {
    public static void main(String[] args) {
        BeanConvert convert = new BeanConvert();

        B1 b = new B1();
        b.setB(2);
        b.setSb("b1 sb");
        b.setC(C.A);

        A1 a = new A1();
        a.setA(1);
        a.setB(b);
        a.setName("A1 name");
        a.setC(1);

        List<B1> list = new ArrayList<>();
        list.add(b);
        list.add(b);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        a.setBList(list);
        a.setIntegers(integers);

        A2 ab = new A2();
        // ab.setBList((List<B2> )list);
        BeanUtils.copyProperties(a, ab);

        A2 a2 = convert.clone(a, A2.class);
        System.out.println("-----------a2 = " + a2);
        System.out.println("-----------ab = " + ab);

    }
}
