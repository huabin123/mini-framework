package prototypebean.context;

import prototypebean.beans.factory.HierarchicalBeanFactory;
import prototypebean.beans.factory.ListableBeanFactory;
import prototypebean.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
