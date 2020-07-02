package event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author baozc
 * @date 2019/11/7 11:27 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String pasword;
}
