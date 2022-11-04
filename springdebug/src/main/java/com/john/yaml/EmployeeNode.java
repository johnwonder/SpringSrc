package com.john.yaml;


import java.util.List;

/**
 * @Description: 人员类
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public final class EmployeeNode extends Node{

	/**
	 * 手机号
	 */
	private String phoneNum;
	/**
	 * 工号
	 */
	private String jobNum;
	/**
	 * 身份证
	 */
	private String cardNum;

	/**
	 * 职位列表
	 */
	private List<JobTitle> titles;

    /**
	 * 默认部门
	 */
	private String defaultUnit;

	/**
	 * 邮箱
	 */
	private String email;

	public EmployeeNode(String id, String code, String value, String type, String phoneNum, String jobNum, String cardNum,
						List<JobTitle> titles, String email, String source, String defaultUnit) {
		super(id,value, type, code,source);
		this.phoneNum = phoneNum;
		this.jobNum = jobNum;
		this.cardNum = cardNum;
		this.titles = titles;
		this.email = email;
	}
//	private EmployeeNode(String id, String code,String value, String type,String phoneNum, String jobNum, String cardNum,
//						 List<JobTitle> titles,String email,String source,String defaultUnit) {
//		super(id,value, type, code,source);
//		this.phoneNum = phoneNum;
//		this.jobNum = jobNum;
//		this.cardNum = cardNum;
//		this.titles = titles;
//		this.email = email;
//		this.defaultUnit =defaultUnit;
//	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String phoneNum = null;
		private String jobNum = null;

		private String cardNum = null;

		private List<JobTitle> titles = null;
		private String email = null;

		private String type = null;
		private String code =null;
		private String id= null;
		private String value =null;
		private String source =null;
		private String defaultUnit;

		private Builder() {
		}

		public EmployeeNode build() {
			return new EmployeeNode(id,code,value,type,phoneNum, jobNum,
					cardNum, titles, email,source,defaultUnit);
		}

		/**
         * 主键
		 * @param id
         * @return
         */
		public Builder id(String id) {
			this.id = id;
			return this;
		}

        /**
         * 编码
		 * @param code
         * @return
         */
		public Builder code(String code) {
			this.code = code;
			return this;
		}

        /**
         * 名称
		 * @param value
         * @return
         */
		public Builder value(String value) {
			this.value = value;
			return this;
		}
		/**
		 * 数据来源
		 * @param source
		 * @return
		 */
		public Builder source(String source) {
			this.source = source;
			return this;
		}

		/**
         * 类型
		 * @param type
         * @return
         */
		public Builder type(String type) {
			this.type = type;
			return this;
		}

        /**
         * 电话号码
		 * @param phoneNum
         * @return
         */
		public Builder phoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
			return this;
		}

        /**
         * 工号
		 * @param jobNum
         * @return
         */
		public Builder jobNum(String jobNum) {
			this.jobNum = jobNum;
			return this;
		}

        /**
         * 身份证
		 * @param cardNum
         * @return
         */
		public Builder cardNum(String cardNum) {
			this.cardNum = cardNum;
			return this;
		}

        /**
         * 职位列表
		 * @param titles
         * @return
         */
		public Builder titles(List<JobTitle> titles) {
			this.titles = titles;
			return this;
		}

        /**
         * 邮箱
		 * @param email
         * @return
         */
		public Builder email(String email) {
			this.email = email;
			return this;
		}

		/**
		 * 默认部门
		 * @param defaultUnit
		 * @return
		 */
		public Builder unitDefault(String defaultUnit) {
			this.defaultUnit = defaultUnit;
			return this;
		}
	}


	public String getPhoneNum() {
		return phoneNum;
	}

	public String getJobNum() {
		return jobNum;
	}


	public String getCardNum() {
		return cardNum;
	}



	public List<JobTitle> getTitles() {
		return titles ;
	}


	public String getEmail() {
		return email;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public void setTitles(List<JobTitle> titles) {
		this.titles = titles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDefaultUnit() {
		return defaultUnit;
	}

	public void setDefaultUnit(String defaultUnit) {
		this.defaultUnit = defaultUnit;
	}
}
