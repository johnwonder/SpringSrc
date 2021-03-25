## 类
org.springframework.beans.factory.xml.BeanDefinitionParserDelegate：

负责解析xml配置文件的代理类

```java
public class BeanDefinitionParserDelegate {
    public BeanDefinitionHolder parseBeanDefinitionElement(Element ele, @Nullable BeanDefinition containingBean) {

    }
}
```
解析完bean元素返回一个```BeanDefinitionHolder```，就注册beandefinition,```BeanDefinitionReaderUtils.registerBeanDefinition```


1. BeanDefinition的Bean名称是放在BeanDefinitionHolder中的，不是BeanDefinition的元数据
2. constructorArgumentValues 是AbstractBeanDefinition的成员变量，BeanDefinition接口只定义了获取ConstructorArguments的方法
   和判断是否有constructorArgumentValues的方法
```java
public interface BeanDefinition {
        /**
	 * Return the constructor argument values for this bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the ConstructorArgumentValues object (never {@code null})
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * Return if there are constructor argument values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}
}
```

3. propertyValues 是AbstractBeanDefinition的成员变量，BeanDefinition接口只定义了获取propertyValues的方法
   和判断是否有propertyValues的方法
4. autowireMode  是AbstractBeanDefinition的成员变量,BeanDefinition接口并未跟autowireMode产生关联。

BeanDefinition定义了beanClassName,scope,lazyInit,initMethodName,destroyMethodName

通过BeanDefinitionBuilder**使用工厂方法**创建BeanDefinition
通过GenericBeanDefinition构造一个实例。

MutablePropertyValues可以通过**Builder模式**添加属性值。
