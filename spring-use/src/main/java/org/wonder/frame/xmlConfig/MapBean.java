package org.wonder.frame.xmlConfig;

import java.util.List;
import java.util.Map;

/**
 * @Description: Map Bean配置
 * @Author: johnwonder
 * @Date: 2021/3/17
 */
public class MapBean {

	private Map<String, Object> maps;

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}


	@Override
	public String toString() {
		return "MapBean{" +
				"maps=" + maps +
				'}';
	}
}
