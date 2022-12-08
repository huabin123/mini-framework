package eventandeventlistener.context.event;

import eventandeventlistener.context.ApplicationEvent;
import eventandeventlistener.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
