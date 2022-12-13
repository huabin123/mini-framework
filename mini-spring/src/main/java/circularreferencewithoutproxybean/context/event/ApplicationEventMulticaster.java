package circularreferencewithoutproxybean.context.event;

import circularreferencewithoutproxybean.context.ApplicationEvent;
import circularreferencewithoutproxybean.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
