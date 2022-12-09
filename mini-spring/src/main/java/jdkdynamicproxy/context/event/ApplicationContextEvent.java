package jdkdynamicproxy.context.event;

import jdkdynamicproxy.context.ApplicationContext;
import jdkdynamicproxy.context.ApplicationEvent;

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
