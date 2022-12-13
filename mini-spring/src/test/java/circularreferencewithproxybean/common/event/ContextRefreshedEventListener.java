package circularreferencewithproxybean.common.event;


import circularreferencewithoutproxybean.context.ApplicationListener;
import circularreferencewithoutproxybean.context.event.ContextRefreshedEvent;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(this.getClass().getName());
	}
}
