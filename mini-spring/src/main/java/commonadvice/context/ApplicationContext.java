package commonadvice.context;

import commonadvice.beans.factory.HierarchicalBeanFactory;
import commonadvice.beans.factory.ListableBeanFactory;
import commonadvice.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
