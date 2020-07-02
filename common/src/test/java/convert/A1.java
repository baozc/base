package convert;

import java.util.List;

import lombok.Data;

/**
 * @author baozc
 * @date 2020/7/1 6:53 PM
 */
@Data
public class A1 {
    private int a;
    private String name;
    private B1 b;
    private Integer c;
    private List<B1> bList;
    private List<Integer> integers;
}
