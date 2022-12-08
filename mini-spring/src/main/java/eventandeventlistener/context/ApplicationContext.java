package eventandeventlistener.context;

import eventandeventlistener.beans.factory.HierarchicalBeanFactory;
import eventandeventlistener.beans.factory.ListableBeanFactory;
import eventandeventlistener.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
