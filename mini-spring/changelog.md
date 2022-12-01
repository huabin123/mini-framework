# IOC
## 最简单的Bean容器
> package:simplebeancontainer

定义了一个简单的bena容器，并且只有注册和获取bean的方法。
## BeanDefinition和BeanDefinitionRegistry
> package:beandefinitionandbeandefinitionregisty

主要增加如下类：

- BeanDefinition，顾名思义，用于定义bean信息的类，包含bean的class类型、构造参数、属性值等信息，每个bean对应一个BeanDefinition的实例。简化BeanDefinition仅包含bean的class类型。
- BeanDefinitionRegistry，BeanDefinition注册表接口，定义注册BeanDefinition的方法。
- SingletonBeanRegistry及其实现类DefaultSingletonBeanRegistry，定义添加和获取单例bean的方法。
bean容器作为BeanDefinitionRegistry和SingletonBeanRegistry的实现类，具备两者的能力。向bean容器中注册BeanDefinition后，使用bean时才会实例化。

## Bean实例化策略InstantiationStrategy
> package:instantiationstrategy

之前创建bean的方法是在AbstractAutowireCapableBeanFactory#doCreateBean中用newInstance方法实现的，仅适用于bean有无参构造的情况。
针对bean的实例化，抽象出一个实例化策略的接口InstantiationStrategy，有两个实现类：
- SimpleInstantiationStrategy，使用bean的构造函数来实例化
- CglibSubclassingInstantiationStrategy，使用CGLIB动态生成子类

## 为Bean填充属性
> package:populatebeanwithpropertyvalues

在BeanDefinition中增加bean属性对应的PropertyValues,实例化bean之后，为bean填充属性。
(AbstractAutowireCapableBeanFactory#applyPropertyValues)。

## 为Bean注入Bean
> package:populatebeanwithbean

增加BeanReference类，包装一个bean对另一个bean的引用。实例化beanA后填充属性时，若PropertyValue#value为BeanReference，引用beanB，则先去实例化beanB。 由于不想增加代码的复杂度提高理解难度，暂时不支持循环依赖，后面会解决该问题。

## 资源和资源加载器
> package:resourceandresourceloader


