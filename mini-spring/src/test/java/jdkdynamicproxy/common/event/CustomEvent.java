package jdkdynamicproxy.common.event;


import jdkdynamicproxy.context.ApplicationContext;
import jdkdynamicproxy.context.event.ApplicationContextEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class CustomEvent extends ApplicationContextEvent {

	public CustomEvent(ApplicationContext source) {
		super(source);
	}
}
