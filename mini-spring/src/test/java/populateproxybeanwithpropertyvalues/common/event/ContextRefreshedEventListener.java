package populateproxybeanwithpropertyvalues.common.event;


import populateproxybeanwithpropertyvalues.context.ApplicationListener;
import populateproxybeanwithpropertyvalues.context.event.ContextRefreshedEvent;

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
