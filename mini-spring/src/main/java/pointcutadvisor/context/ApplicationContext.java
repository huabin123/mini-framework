package pointcutadvisor.context;

import pointcutadvisor.beans.factory.HierarchicalBeanFactory;
import pointcutadvisor.beans.factory.ListableBeanFactory;
import pointcutadvisor.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
