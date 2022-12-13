package autowiredannotation.context.event;

import autowiredannotation.context.ApplicationContext;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public class ContextClosedEvent extends ApplicationContextEvent {

	public ContextClosedEvent(ApplicationContext source) {
		super(source);
	}
}
