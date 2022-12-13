package autowiredannotation.context;

import autowiredannotation.beans.factory.HierarchicalBeanFactory;
import autowiredannotation.beans.factory.ListableBeanFactory;
import autowiredannotation.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
