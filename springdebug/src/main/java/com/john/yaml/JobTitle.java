package com.john.yaml;

/**
 * @Description: 职位类
 * @Author: johnwonder
 * @Date: 2022/10/25
 */
public class JobTitle {

    /**
     * 职位主数据id
     */
    private String id;
    /**
     * 职位编码
     */
    private String code;
    /**
     * 职位名称
     */
    private String title;

    /**
     * 职位所属机构id
     */
    private String unitId;

	public JobTitle(String id, String code, String title, String unitId) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.unitId = unitId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}
