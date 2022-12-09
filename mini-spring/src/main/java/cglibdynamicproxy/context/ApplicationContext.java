package cglibdynamicproxy.context;

import cglibdynamicproxy.beans.factory.HierarchicalBeanFactory;
import cglibdynamicproxy.beans.factory.ListableBeanFactory;
import cglibdynamicproxy.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
