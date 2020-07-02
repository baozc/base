package convert;

import java.util.List;

import lombok.Data;

/**
 * @author baozc
 * @date 2020/7/1 6:53 PM
 */
@Data
public class A2 {
    private int a;
    private String name;
    private B2 b;
    private Long c;
    private List<B2> bList;
    private List<Integer> integers;
}
