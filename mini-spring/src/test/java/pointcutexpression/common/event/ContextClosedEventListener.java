package pointcutexpression.common.event;

import pointcutexpression.context.ApplicationListener;
import pointcutexpression.context.event.ContextClosedEvent;

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
