package circularreferencewithoutproxybean.context.event;

import circularreferencewithoutproxybean.context.ApplicationContext;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

	public ContextRefreshedEvent(ApplicationContext source) {
		super(source);
	}
}
