package applicationcontext.context;

import applicationcontext.beans.factory.HierarchicalBeanFactory;
import applicationcontext.beans.factory.ListableBeanFactory;
import applicationcontext.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
