package cglibdynamicproxy.common.event;


import cglibdynamicproxy.context.ApplicationContext;
import cglibdynamicproxy.context.event.ApplicationContextEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class CustomEvent extends ApplicationContextEvent {

	public CustomEvent(ApplicationContext source) {
		super(source);
	}
}
