package packagescan.context;

import packagescan.beans.factory.HierarchicalBeanFactory;
import packagescan.beans.factory.ListableBeanFactory;
import packagescan.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
