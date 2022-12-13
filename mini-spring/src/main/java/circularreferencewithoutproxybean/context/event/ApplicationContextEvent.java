package circularreferencewithoutproxybean.context.event;

import circularreferencewithoutproxybean.context.ApplicationContext;
import circularreferencewithoutproxybean.context.ApplicationEvent;

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
