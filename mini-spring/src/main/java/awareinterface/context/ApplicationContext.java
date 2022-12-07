package awareinterface.context;

import awareinterface.beans.factory.HierarchicalBeanFactory;
import awareinterface.beans.factory.ListableBeanFactory;
import awareinterface.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
