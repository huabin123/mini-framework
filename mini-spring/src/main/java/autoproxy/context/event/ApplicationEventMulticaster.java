package autoproxy.context.event;

import autoproxy.context.ApplicationEvent;
import autoproxy.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
