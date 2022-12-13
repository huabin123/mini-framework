package valueannotation.context;

import valueannotation.beans.factory.HierarchicalBeanFactory;
import valueannotation.beans.factory.ListableBeanFactory;
import valueannotation.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
