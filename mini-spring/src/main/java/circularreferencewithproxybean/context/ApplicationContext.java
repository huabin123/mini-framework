package circularreferencewithproxybean.context;

import circularreferencewithproxybean.beans.factory.HierarchicalBeanFactory;
import circularreferencewithproxybean.beans.factory.ListableBeanFactory;
import circularreferencewithproxybean.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}