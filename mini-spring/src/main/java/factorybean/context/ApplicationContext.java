package factorybean.context;

import factorybean.beans.factory.HierarchicalBeanFactory;
import factorybean.beans.factory.ListableBeanFactory;
import factorybean.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
