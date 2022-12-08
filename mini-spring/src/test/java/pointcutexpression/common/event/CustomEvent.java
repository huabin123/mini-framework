package pointcutexpression.common.event;


import pointcutexpression.context.ApplicationContext;
import pointcutexpression.context.event.ApplicationContextEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class CustomEvent extends ApplicationContextEvent {

	public CustomEvent(ApplicationContext source) {
		super(source);
	}
}
