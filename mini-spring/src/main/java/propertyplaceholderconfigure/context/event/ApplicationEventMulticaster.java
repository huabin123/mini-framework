package propertyplaceholderconfigure.context.event;

import propertyplaceholderconfigure.context.ApplicationEvent;
import propertyplaceholderconfigure.context.ApplicationListener;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
