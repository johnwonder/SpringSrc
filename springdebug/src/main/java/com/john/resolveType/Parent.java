package com.john.resolveType;

/**
 * 测试继承获取泛型
 *
 * @author: wangji
 * @date: 2018/06/25 20:34
 */
public class Parent<String> {

}

//<? extends T>和<? super T>是Java泛型中的“通配符（Wildcards）”和“边界（Bounds）”的概念。
//<? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”
//<? super T>：是指 “下界通配符（Lower Bounds Wildcards）”
//这就是三句话总结JAVA泛型通配符（PECS）中的第一句话：?”不能添加元素，只能作为消费者
//因为对于 List<?> 中的元素只能用 Object 来引用，在有些情况下不是很方便。在这些情况下，可以使用上下界来限制未知类型的范围。
//List<? extends Number> 说明 List 中可能包含的元素类型是 Number 及其子类。而 List<? super Number> 则说明 List 中包含的是 Number 及其父类
//https://blog.csdn.net/deargua/article/details/76100881

//    /请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。站在泛型容器的角度，容器是吸收对象（Consumer向容器中写入）还是提供对象（Producer从容器中产生读取）
//
//    生产者使用extends
//    如果你需要一个列表提供T类型的元素（即你想从列表中读取T类型的元素），你需要把这个列表声明成<? extends T>，比如List<? extends Integer>，因此你不能往该列表中添加任何元素。
//
//    消费者使用super
//    如果需要一个列表使用T类型的元素（即你想把T类型的元素加入到列表中），你需要把这个列表声明成<? super T>，比如List<? super Integer>，因此你不能保证从中读取到的元素的类型。
//https://blog.csdn.net/deargua/article/details/76100881
//public class WildcardParent<? super T>{
//
//}

