package circularreferencewithproxybean.context.event;

import circularreferencewithproxybean.context.ApplicationEvent;
import circularreferencewithproxybean.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
