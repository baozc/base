package event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author baozc
 * @date 2019/11/7 11:46 PM
 */
@Component
public class UserPublish {
    @Autowired
    ApplicationContext context;

    public void publish(){
        context.publishEvent(new UserRegisterEvent(null, new User("name", "pwd")));
    }
}
