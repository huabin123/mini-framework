package propertyplaceholderconfigure.context;

import propertyplaceholderconfigure.beans.factory.HierarchicalBeanFactory;
import propertyplaceholderconfigure.beans.factory.ListableBeanFactory;
import propertyplaceholderconfigure.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
