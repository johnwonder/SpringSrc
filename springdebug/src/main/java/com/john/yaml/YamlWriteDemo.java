package com.john.yaml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public class YamlWriteDemo {

	public static void main(String[] args) throws IOException {

		Node node = new UnitNode("无锡宝通科技股份有限公司","A","bt");

		Node sNode1 = new UnitNode("无锡百年通工业输送有限公司","O","bnt");
		Node sNode2 = new UnitNode("山东新宝龙","O","xbl");

		node.addAllNode(sNode1,sNode2);
		for (int i = 0; i < 200; i++) {
			Node sNode = new UnitNode("无锡百年通工业输送有限公司"+i,"O","bnt");
			node.addNode(sNode);
		}

		Node sNode1Child1 = new UnitNode("总经办","O","zjb");
		EmployeeNode child1LeafNode  = new EmployeeNode("李勇恒","U","BNT00011");
		EmployeeNode child1LeafNode1  = new EmployeeNode("卫志强","U","BNT001");
		for (int i = 0; i < 1000; i++) {
			EmployeeNode employeeNode  = new EmployeeNode("李勇恒"+i,"U","BNT00011");
			sNode1Child1.addNode(employeeNode);
		}
		sNode1Child1.addNode(child1LeafNode);

		sNode1Child1.addNode(child1LeafNode1);


		Node sNode1Child2 = new UnitNode("项目部","O","xmb");
		Node child2LeafNode  = new EmployeeNode("谢丁丁","U","BNT0021");
		Node child2LeafNode1  = new EmployeeNode("郁浩钧","U","BNT021");
		sNode1Child2.addNode(child2LeafNode);
		sNode1Child2.addNode(child2LeafNode1);


		sNode1.addNode(sNode1Child1);
		sNode1.addNode(sNode1Child2);

		Node sNode2Child1 = new UnitNode("人力资源","O","hr");
		sNode2.addNode(sNode2Child1);

		//设置yml格式，一般使用的是最喜欢的格式
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setCanonical(false);

		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		//2.创建FileWriter
		FileWriter fileWriter = new FileWriter("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/resources/unit.yml");
		//3.创建yaml类
		//YAML类是API的入口点
		Yaml yaml = new Yaml(dumperOptions);
//		//yml文件使用 LinkedHashMap来存储的
//		LinkedHashMap<String, Object> ymlMap = new LinkedHashMap<>();
//		//使用put方法添加内容
//		ymlMap.put("unit", node);
		//dump方法生成yaml
		yaml.dump(node, fileWriter);
//————————————————
//		版权声明：本文为CSDN博主「刷题刷题nn」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//		原文链接：https://blog.csdn.net/weixin_41413137/article/details/119004990
	}
}
