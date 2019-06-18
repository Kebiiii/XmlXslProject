package com.apecircle.easytranslib.bean;

public class XlsWriteBean {
	private Builder mBuilder;
	public XlsWriteBean(Builder builder){
		mBuilder = builder;
	}
	
	public Builder getBuilder(){
		return mBuilder;
	}
	
	
	public static class Builder{
		String rootPath;
		String xlsName = "workbook.xls";
		String fileFloderName;
		
		public Builder setRootPath(String rootPath) {
			this.rootPath = rootPath;
			return this;
		}
		
		public Builder setXlsName(String xlsName) {
			this.xlsName = xlsName;
			return this;
		}
		
		public Builder setFileFloderName(String fileFloderName) {
			this.fileFloderName = fileFloderName;
			return this;
		} 
		
		public XlsWriteBean builder(){
			return new XlsWriteBean(this);
		}
	
		
		public String getRootPath() {
			return rootPath;
			
		}
		public String getXlsName() {
			return xlsName;
		}
		
		public String getFileFloderName() {
			return fileFloderName;
		}
	}


	private static void checkNull(Builder builder) {
		// TODO Auto-generated method stub
		if(builder.getRootPath() == null){
			throw new NullPointerException("you need to set root path!");
		}
		
		if(builder.getFileFloderName() == null){
			throw new NullPointerException("you need to set file name!");
		}
		
	}
}
