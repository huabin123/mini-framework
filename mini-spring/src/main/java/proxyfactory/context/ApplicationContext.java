package proxyfactory.context;

import proxyfactory.beans.factory.HierarchicalBeanFactory;
import proxyfactory.beans.factory.ListableBeanFactory;
import proxyfactory.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
