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

## 在xml文件中定义bean

> package:xmlfiledefinebean

XmlBeanDefinitionReader实现BeanDefinitionReader接口，对xml中的bean信息进行解析

## BeanFactoryPostProcessor和BeanPostProcessor

> package:beanfactorypostprocessorandbeanpostprocessor

BeanFactoryPostProcessor和BeanPostProcessor是spring框架中具有重量级地位的两个接口，理解了这两个接口的作用，基本上就理解spring的核心原理了。

BeanFactoryPostProcessor是spring提供的容器扩展机制，允许我们在bean实例化之前修改bean的定义信息，即BeanDefinition的信息。其重要的实现类有
PropertyPlaceholderConfigurer和CustomEditorConfigurer。

- **PropertyPlaceholderConfigurer**的作用是用properties文件的配置值替换xml文件中的占位符。
- **CustomEditorConfigurer**的作用是实现类型转换

单元测试类：BeanFactoryPostProcessorAndBeanPostProcessorTest#testBeanFactoryPostProcessor

同时为了适应新的场景以及尽量保持和spring中BeanFactory的继承层次一致，增加了ConfigurableListableBeanFactory，ConfigurableBeanFactory，HierarchicalBeanFactory

BeanPostProcessor也是spring提供的容器扩展机制，不同于BeanFactoryPostProcessor的是BeanPostProcessor是在bean实例化之后修改bean或者
替换bean。BeanPostProcessor是后面实现AOP的关键。

BeanPostProcessor的两个方法分别在bean执行初始化方法（后面实现）之前和之后执行。
单元测试类：BeanFactoryPostProcessorAndBeanPostProcessorTest#testBeanPostProcessor和AbstractAutowireCapableBeanFactory#initializeBean方法

## 应用上下文ApplicationContext

> package:applicationcontext

应用上下文ApplicationContext是spring中较之于BeanFactory更为先进的IOC容器，ApplicationContext除了拥有BeanFactory的全部功能之外，还
支持特殊类型bean，如上一节中的BeanFactoryBeanPostProcessor和BeanPostProcessor，能对他们进行自动识别，资源加载，容器事件和监听器，国际化
支持、单例bean自动初始化等。

BeanFactory是spring的基础设施，面相spring本省；ApplicationContext面相的是spring的使用者，在一般的应用中都是使用ApplicationContext。

具体实现查看AbstractApplicationContext#refresh方法即可。注意BeanFactoryPostProcessor和BeanPostProcessor的自定识别，这样就可以在xml文件中配置二者而不需要像上一节一样手动添加到容器中了。

从bean的角度看，目前的生命周期如下：

![](./assets/application-context-life-cycle.png)

## bean的初始化和销毁方法

> package:initanddestroymethod

在spring中，定义bean的初始化和销毁方法有三种方法：

- 在xml文件中制定init-method和destroy-method
- 继承自InitializingBean和DisposableBean
- 在方法上加注解PostConstruct和PreDestroy

第三种通过BeanPostProcessor实现，在后续实现，本节只实现前两种。

针对第一种在xml文件中指定初始化和销毁方法的方式，在BeanDefinition中增加属性initMethodName和destroyMethodName。

初始化方法在AbstractAutowireCapableBeanFactory#invokeInitMethods执行。DefaultSingletonBeanRegistry中增加属性disposableBeans
保存拥有销毁方法的bean，拥有销毁方法的bean在AbstractAutowireCapableBeanFactory#registerDisposableBeanIfNecessary中注册到disposableBeans中。

为了确保销毁方法虚拟机关闭之前执行，向虚拟机中注册一个钩子方法，查看AbstractApplicationContext#registerShutdownHook（非web应用需要手动
调用该方法）。当然也可以手动调用ApplicationContext#close方法关闭容器。

到此为止Bean的声明周期如下：

![](./assets/init-and-destroy-method.png)

## Aware接口

> package:awareinterface

Aware是感知、意识的意思，Aware接口是标记性接口，其实现子类能感知容器相关的对象。常用的Aware接口有BeanFactoryAware和ApplicationContextAware，分别能让其实现者感知所属的BeanFactory和ApplicationContext。

让实现BeanFactoryAware接口的类能感知所属的BeanFactory，实现比较简单，查看AbstractAutowireCapableBeanFactory#initializeBean前三行。

实现ApplicationContextAware的接口感知ApplicationContext，是通过BeanPostProcessor。由bean的生命周期可知，bean实例化后会经过BeanPostProcessor的前置处理和后置处理。定义一个BeanPostProcessor的实现类ApplicationContextAwareProcessor，在AbstractApplicationContext#refresh方法中加入到BeanFactory中，在前置处理中为bean设置所属的ApplicationContext。

改用dom4j解析xml文件。

至止，bean的生命周期如下：

![](./assets/aware-interface.png)

## bean作用域，增加prototype的支持

> package:prototypebean

每次向容器中获取prototype类型的bean时，容器都会创建一个新的实例。需要做以下改造：

- 在BeanDefinition中增加bean的作用域的字段scope
- 创建prototype类型的bean时，不往singletonObjects中增加该bean，参见：AbstractAutowireCapableBeanFactory#doCreateBean
- prototype作用域bean不执行销毁方法，参见：AbstractAutowireCapableBeanFactory#registerDisposableBeanIfNecessary方法
- XmlBeanDefinitionReader中解析xml中的scope属性

至此bean生命周期如下：

![](./assets/prototype-bean.png)

## FactoryBean

> package:factorybean

FactoryBean是一种特殊的bean，当向容器获取该bean时，容器不是返回其本身，而是返回其FactoryBean#getObject方法的返回值，可通过编码方式定义复杂的bean。

实现逻辑比较简单，当容器发现bean为FactoryBean类型时，调用其getObject方法返回最终bean。当FactoryBean#isSingleton==true，将最终bean放进缓存中，下次从缓存中获取。改动点见AbstractBeanFactory#getBean。

## 容器事件和事件监听器

> package:eventandeventlistener

spring的ApplicationContext容器提供了完整的事件发布和事件监听功能。

ApplicationEventMulticaster接口是注册监听器和发布事件的抽象接口，AbstractApplicationContext包含其实现类实例作为其属性，使得ApplicationContext
容器具有注册监听器和发布事件的能力。

在AbstractApplicationContext#refresh方法中，会实例化ApplicationEventMulticaster、注册监听器并发布容器刷新事件ContextRefreshedEvent；

在AbstractApplicationContext#doClose方法中，发布容器关闭事件ContextClosedEvent。

# AOP

## 切点表达式

> package:pointcutexpression

JointPoint，织入点，指需要进行代理操作的某个类的某个方法（仅支持方法级别的JointPoint）。Pointcut是JoinPoint的表述方式，能捕获JoinPoint。

最常用的切点表达式是AspectJ的切点表达式。需要匹配类，定义ClassFilter接口；匹配方法，定义MethodMatcher方法，AspectJExpressionPointcut是
支持AspectJ切点表达式的PointCut实现，简单实现仅支持execution函数。

## 基于JDK的动态代理

> package:jdkdynamicproxy

AopProxy是获取代理对象的抽象接口，JdkDynamicAopProxy是基于JDK动态代理的具体实现。TargetSource，被代理对象的封装。

MethodInterceptor，方法拦截器，是AOP Alliance的"公民"，顾名思义，可以拦截方法，可在被代理执行的方法前后增加代理行为。

## 基于CGLIB的动态代理

> package:cglibdynamicproxy

基于CGLIB的动态代理实现逻辑也比较简单，查看CglibAopProxy。与基于JDK的动态代理在运行期间为接口生成对象的代理对象不同，基于CGLIB的动态代理能
在运行期间动态构建字节码的class文件，为类生成子类，因此被代理类不需要继承自任何接口。

## AOP代理工厂

> package:proxyfactory

增加AOP代理工厂ProxyFactory，由AdvisedSupport#proxyTargetClass属性决定使用Jdk动态代理还是Cglib动态代理。

## 几种常用的Advice：BeforeAdvice/AfterAdvice/AfterReturningAdvice/ThrowsAdvice...

> package:commonadvice

Spring将AOP联盟中的Advice细化出各种类型的Advice，常用的有BeforeAdvice/AfterAdvice/AfterReturningAdvice/ThrowsAdvice，我们可以通过扩展MethodInterceptor来实现。

这里只简单实现BeforeAdvice，定义MethodBeforeAdviceInterceptor拦截器，在执行被代理方法之前，先执行BeforeAdvice的方法。

## PointcutAdvisor：Pointcut和Advice的组合

> package:pointcutadvisor

Advisor是包含一个Pointcut和一个Advice的组合，Pointcut用于捕获JointPoint，Advice决定在JointPoint执行某种操作。实现了一个支持AspectJ表达式
的AspectJExpressionPointcutAdvisor。

## 动态代理融入bean生命周期

> package:autoproxy

结合前面讲解的bean的生命周期，BeanPostProcessor处理阶段可以修改和替换bean，正好可以在此阶段返回代理对象替换原对象。不过我们引入一种特殊的
BeanPostProcessor--InstantiationAwareBeanPostProcessor，如果InstantiationAwareBeanPostProcessor处理阶段返回代理对象，会导致
短路，不会继续走原来的创建bean的流程，具体实现查看AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation。

DefaultAdvisorAutoProxyCreator是处理横切逻辑的织入返回代理对象InstantiationAwareBeanPostProcessor的实现类，当对象实例化时，生成代理对象并返回。

至此，bean的生命周期如下：

![](./assets/auto-proxy.png)

## PropertyPlaceholderConfigure

> package:propertyplaceholderconfigure

经常需要将配置信息配置在properties文件中，然后在XML文件中以占位符的方式引用。

实现思路很简单，在bean实例化之前，编辑BeanDefinition，解析XML文件中的占位符，然后用properties文件中的配置值替换占位符。
而BeanFactoryPostProcessor具有编辑BeanDefinition的能力，因此PropertyPlaceholderConfigurer继承自BeanFactoryPostProcessor。

## 包扫描

> package:packagescan

结合bean的生命周期，包扫描只不过是扫描特定注解的类，提取类的相关信息组装成BeanDefinition注册到容器中。

在XmlBeanDefinitionReader中解析<context:component-scan />标签，

在ClassPathBeanDefinitionScanner#doScan中扫描类并组装BeanDefinition然后注册到容器中。

## @Value注解

> package:valueannotation

注解@Value和@Autowired通过BeanPostProcessor处理。InstantiationAwareBeanPostProcessor增加postProcessPropertyValues方法，在bean实例化之后设置属性之前执行，查看AbstractAutowireCapableBeanFactory#doCreateBean方法。

增加AutowiredAnnotationBeanPostProcessor用于处理注解@Value，@Autowired的处理在下一节实现，在ClassPathBeanDefinitionScanner#doScan将其添加到容器中。查看AutowiredAnnotationBeanPostProcessor#postProcessPropertyValues，其中字符解析器StringValueResolver在PropertyPlaceholderConfigurer中添加到BeanFactory中。

## @Autowired注解

> package:autowiredannotation

@Autowired注解的处理见AutowiredAnnotationBeanPostProcessor#postProcessPropertyValues

## bug fix：没有为代理bean设置属性

> package:populateproxybeanwithpropertyvalues

问题现象：没有为代理bean设置属性。

问题原因：织入逻辑在InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation中执行，而该方法如果返回非null，会导致"短路"，不会执行后面的设置属性逻辑。因此如果该方法中返回代理bean后，不会为代理bean设置属性。

修复方案：跟spring保持一致，将织入逻辑迁移到BeanPostProcessor#postProcessAfterInitialization，即将DefaultAdvisorAutoProxyCreator#postProcessBeforeInstantiation的内容迁移到DefaultAdvisorAutoProxyCreator#postProcessAfterInitialization中。

顺便完善spring的扩展机制，为InstantiationAwareBeanPostProcessor增加postProcessAfterInstantiation方法，该方法在bean实例化之后设置属性之前执行。

至此，bean的生命周期比较完整了，如下：
![](assets/populate-proxy-bean-with-property-values.png)

## 解决循环依赖问题（一）：没有代理对象

> package:circularreferencewithoutproxybean

先理解spring中为什么会有循环依赖的问题。比如如下的代码

```java
public class A {

	private B b;

	//getter and setter
}
```

```java
public class B {

	private A a;

	//getter and setter
}
```

A依赖B，B又依赖A，循环依赖。容器加载时会执行依赖流程：

- 实例化A，发现依赖B，然后实例化B
- 实例化B，发现依赖A，然后实例化A
- 实例化A，发现依赖B，然后实例化B
- ...
  死循环直至栈溢出。

解决该问题的关键在于何时将实例化后的bean放进容器中，设置属性前还是设置属性后。现有的执行流程，
bean实例化后并且设置属性后会被放进singletonObjects单例缓存中。如果我们调整一下顺序，当bean实例化后就放进singletonObjects单例缓存中，
提前暴露引用，然后再设置属性，就能解决上面的循环依赖问题，执行流程变为：

- 步骤一：getBean(a)，检查singletonObjects是否包含a，singletonObjects不包含a，实例化A放进singletonObjects，设置属性b，发现依赖B，尝试getBean(b)
- 步骤二：getBean(b)，检查singletonObjects是否包含b，singletonObjects不包含b，实例化B放进singletonObjects，设置属性a，发现依赖A，尝试getBean(a)
- 步骤三：getBean(a)，检查singletonObjects是否包含a，singletonObjects包含a，返回a
- 步骤四：步骤二中的b拿到a，设置属性a，然后返回b
- 步骤五：步骤一中的a拿到b，设置属性b，然后返回a

可见调整bean放进singletonObjects（人称一级缓存）的时机到bean实例化后即可解决循环依赖问题。但为了和spring保持一致，
我们增加一个二级缓存earlySingletonObjects，在bean实例化后将bean放进earlySingletonObjects中（见AbstractAutowireCapableBeanFactory#doCreateBean方法第6行），getBean()时检查一级缓存singletonObjects和二级缓存earlySingletonObjects中是否包含该bean，包含则直接返回（见AbstractBeanFactory#getBean第1行）。

单测见CircularReferenceWithoutProxyBeanTest#testCircularReference。

增加二级缓存，不能解决有代理对象时的循环依赖。原因是放进二级缓存earlySingletonObjects中的bean是实例化后的bean，而放进一级缓存singletonObjects中的bean是代理对象（代理对象在BeanPostProcessor#postProcessAfterInitialization中返回），两个缓存中的bean不一致。比如上面的例子，如果A被代理，那么B拿到的a是实例化后的A，而a是被代理后的对象，即b.getA() != a，见单测CircularReferenceWithProxyBeanTest。

## 解决循环依赖问题（二）：有代理对象

> package:circularreferencewithproxybean

解决有代理对象时的循环依赖问题，需要提前暴露代理对象的引用，而不是暴露实例化后的bean的引用（这是上节的遗留问题的原因，应该提前暴露A的代理对象的引用）。

spring中用singletonFactories（一般称第三级缓存）解决有代理对象时的循环依赖问题。在实例化后提前暴露代理对象的引用（见AbstractAutowireCapableBeanFactory#doCreateBean方法第6行）。

getBean()时依次检查一级缓存singletonObjects、二级缓存earlySingletonObjects和三级缓存singletonFactories中是否包含该bean。如果三级缓存中包含该bean，则挪至二级缓存中，然后直接返回该bean。见AbstractBeanFactory#getBean方法第1行。

最后将代理bean放进一级缓存singletonObjects，见AbstractAutowireCapableBeanFactory第104行。

单测见CircularReferenceWithProxyBeanTest。
