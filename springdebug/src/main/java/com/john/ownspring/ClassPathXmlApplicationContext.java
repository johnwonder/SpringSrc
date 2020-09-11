package com.john.ownspring;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {


	@Override
	public Object getBean(String beanName) {
		return null;
	}

	//定位配置文件
	public ClassPathXmlApplicationContext(String configLocation) {


		setConfigLocations(new String[] {configLocation});
		//默认为true
//		if (refresh) {
//			//调用抽象类AbstractApplicationContext中的refresh方法
//			refresh();
//		}
	}

	private String[] configLocations;

	public void setConfigLocations(String... locations) {
		if (locations != null) {
			this.configLocations = new String[locations.length];
			for (int i = 0; i < locations.length; i++) {
				this.configLocations[i] = resolvePath(locations[i]).trim();
			}
		}
		else {
			this.configLocations = null;
		}
	}

	protected String resolvePath(String path) {
		return  "";
		//return getEnvironment().resolveRequiredPlaceholders(path);
	}


}
