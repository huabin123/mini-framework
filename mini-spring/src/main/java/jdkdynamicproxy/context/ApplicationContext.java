package jdkdynamicproxy.context;

import jdkdynamicproxy.beans.factory.HierarchicalBeanFactory;
import jdkdynamicproxy.beans.factory.ListableBeanFactory;
import jdkdynamicproxy.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
