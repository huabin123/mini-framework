package pointcutexpression.context;

import pointcutexpression.beans.factory.HierarchicalBeanFactory;
import pointcutexpression.beans.factory.ListableBeanFactory;
import pointcutexpression.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
