package populateproxybeanwithpropertyvalues.context.event;

import populateproxybeanwithpropertyvalues.context.ApplicationContext;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public class ContextClosedEvent extends ApplicationContextEvent {

	public ContextClosedEvent(ApplicationContext source) {
		super(source);
	}
}
