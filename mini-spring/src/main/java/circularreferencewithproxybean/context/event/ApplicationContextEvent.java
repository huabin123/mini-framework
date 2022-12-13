package circularreferencewithproxybean.context.event;

import circularreferencewithproxybean.context.ApplicationContext;
import circularreferencewithproxybean.context.ApplicationEvent;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

	public ApplicationContextEvent(ApplicationContext source) {
		super(source);
	}

	public final ApplicationContext getApplicationContext() {
		return (ApplicationContext) getSource();
	}
}
