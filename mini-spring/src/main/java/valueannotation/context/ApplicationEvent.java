package valueannotation.context;

import java.util.EventObject;

/**
 * @Author huabin
 * @DateTime 2022-12-08 14:02
 * @Desc
 */
public class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }

}
