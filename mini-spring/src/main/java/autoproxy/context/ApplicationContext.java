package autoproxy.context;

import autoproxy.beans.factory.HierarchicalBeanFactory;
import autoproxy.beans.factory.ListableBeanFactory;
import autoproxy.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
