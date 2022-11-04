package com.john.yaml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public class YamlWriteDemo {

	public static void main(String[] args) throws IOException {

		Node node = new UnitNode("1111","无锡宝通科技股份有限公司","sss","A","bt","HR");

		Node sNode1 = new UnitNode("22","无锡百年通工业输送有限公司","sss","O","bnt","HR");
		Node sNode2 = new UnitNode("33","山东新宝龙","sss","O","xbl","HR");

		node.addAllNode(sNode1,sNode2);
//		for (int i = 0; i < 5; i++) {
//			Node sNode = new UnitNode("无锡百年通工业输送有限公司"+i,"O","bnt");
//			node.addNode(sNode);
//		}

		Node sNode1Child1 = new UnitNode("44","总经办","sss","O","zjb","HR");

		List<JobTitle> titles = new ArrayList<>();
		titles.add(new JobTitle("1","","",""));
		titles.add(new JobTitle("2","","",""));
		EmployeeNode child1LeafNode = EmployeeNode.builder().type("U").jobNum("btzn0018").cardNum("sss").titles(titles).build();

		EmployeeNode child1LeafNode1 = EmployeeNode.builder().jobNum("btzn0020").cardNum("ggg").build();

//		for (int i = 0; i < 3; i++) {
//			EmployeeNode employeeNode  = new EmployeeNode("李勇恒"+i,"U","BNT00011");
//			sNode1Child1.addNode(employeeNode);
//		}
		sNode1Child1.addNode(child1LeafNode);

		sNode1Child1.addNode(child1LeafNode1);


		Node sNode1Child2 = new UnitNode("555","项目部","1","O","xmb","HR");
		EmployeeNode child2LeafNode = EmployeeNode.builder().id("ssasasas").value("aas").code("sss").jobNum("btzn0120").cardNum("aaa").build();
		EmployeeNode child2LeafNode1 = EmployeeNode.builder().jobNum("btzn0220").cardNum("bbb").build();

		sNode1Child2.addNode(child2LeafNode);
		sNode1Child2.addNode(child2LeafNode1);


		sNode1.addNode(sNode1Child1);
		sNode1.addNode(sNode1Child2);

		Node sNode2Child1 = new UnitNode("66","人力资源","1","O","hr","HR");
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
