package cglibdynamicproxy.common.event;

import cglibdynamicproxy.context.ApplicationListener;
import cglibdynamicproxy.context.event.ContextClosedEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println(this.getClass().getName());
	}
}
