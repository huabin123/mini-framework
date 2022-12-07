package initanddestroymethod.context;

import initanddestroymethod.beans.factory.HierarchicalBeanFactory;
import initanddestroymethod.beans.factory.ListableBeanFactory;
import initanddestroymethod.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
